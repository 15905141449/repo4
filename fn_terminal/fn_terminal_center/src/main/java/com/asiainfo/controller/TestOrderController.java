package com.asiainfo.controller;

import com.asiainfo.model.TestOrder;
import com.asiainfo.service.ITestOrderService;
import com.asiainfo.service.ITestPort;
import com.asiainfo.util.DateUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description 订单Controller（示例）
 * @Version 1.0
 * @Author cxl
 * @date 2020/8/11 11:29
 */
@Slf4j
@RestController
public class TestOrderController {
    @Autowired
    private ITestOrderService testOrderService;

    @Autowired
    private ITestPort testPort;

    /**
     * 生成订单
     *
     * @param order 订单对象
     * @return 订单是否创建成功, 如果成功, 返回订单编号
     */
    @RequestMapping(value = "/createOrder")
    public String createOrder(@RequestBody TestOrder order) {
        log.info("创建订单,订单用户ID:{}", order.getUserId());
        testOrderService.createTestOrder(order);
        return "success";
    }

    /**
     * 根据条件分页查询订单
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/queryOrder")
    public PageInfo<List<TestOrder>> queryOrder(@RequestBody Map<String, Object> param) {
        log.info("分页查询订单,查询条件{}", param.toString());
        return testOrderService.queryTestOrderByPage(param, 5, 2);
    }

    /**
     * 查询订单详情
     *
     * @param {"orderId":订单ID}
     * @return TestOrder
     */
    @RequestMapping(value = "/queryOrderDetail")
    public TestOrder queryOrderDetail(@RequestBody Map<String, Object> param) {
        TestOrder order = testOrderService.queryTestOrder((String) param.get("orderId"));
        DateUtil.formatDate(order.getCreateDt());//工具类使用
        return order;
    }

    /**
     * 调用fn_service工程内部方法_查询订单详情
     *
     * @param {"orderId":订单ID}
     * @return TestOrder
     */
    @RequestMapping(value = "/queryOrderDetailUseFnService")
    public TestOrder queryOrderDetailUseFnService(@RequestBody Map<String, Object> param) {
        TestOrder order = testPort.queryOrderDetailByService((String) param.get("orderId"));
        DateUtil.formatDate(order.getCreateDt());//工具类使用
        order.setRemarks(order.getRemarks() + "fn_terminal调用fn_service");
        return order;
    }


}
