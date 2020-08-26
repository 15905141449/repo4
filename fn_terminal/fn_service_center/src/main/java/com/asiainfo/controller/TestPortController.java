package com.asiainfo.controller;

import com.asiainfo.model.TestOrder;
import com.asiainfo.service.ITestPort;
import com.asiainfo.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description 接口工程Controller（示例）
 * @Version 1.0
 * @Author cxl
 * @date 2020/8/12 14:21
 */
@Slf4j
@RestController
public class TestPortController {

    @Autowired
    ITestPort testPort;

    /**
     * 查询订单详情
     * @param {"orderId":订单ID}
     * @return Order
     */
    @RequestMapping(value = "/queryOrderDetailByService")
    public TestOrder queryOrderDetailByService(@RequestBody Map<String,Object> param) {
        log.info("fn_service工程对外提供接口");
        TestOrder order = testPort.queryOrderDetailByService((String) param.get("orderId"));
        DateUtil.formatDate(order.getCreateDt());//工具类使用
        order.setRemarks(order.getRemarks()+"fn_service工程对外提供接口");
        return order;
    }

}
