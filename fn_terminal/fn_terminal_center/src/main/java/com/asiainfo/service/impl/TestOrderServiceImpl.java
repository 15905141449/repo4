package com.asiainfo.service.impl;


import com.asiainfo.mapper.TestOrderMapper;
import com.asiainfo.model.TestOrder;
import com.asiainfo.service.ITestOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description 订单服务接口实现类（示例）
 * @Version 1.0
 * @Author cxl
 * @date 2020/8/11 11:29
 */
@Slf4j
@Service("testOrderService")
public class TestOrderServiceImpl implements ITestOrderService {

    @Autowired
    private TestOrderMapper terOrderMapper;

    /**
     * 生成订单
     *
     * @param order 订单信息类
     * @return
     */
    @Transactional
    public boolean createTestOrder(TestOrder order) {
        try {
            log.info("订单生成Service, 订单ID:{},订单用户ID:{}", order.getOrderId(), order.getUserId());
            terOrderMapper.insertSelective(order);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 根据订单编码查询订单详情
     *
     * @param orderId
     * @return 订单详情
     */
    public TestOrder queryTestOrder(String orderId) {
        log.info("订单详情查询Service, 订单ID:{}", orderId);
        return terOrderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 根据条件分页查询订单
     *
     * @param cond
     * @param pageSize 每页记录条数
     * @param currPage 当前页
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public PageInfo queryTestOrderByPage(Map<String, Object> cond, int pageSize, int currPage) {
        PageHelper.startPage(currPage, pageSize);
        List<TestOrder> orders = terOrderMapper.queryOrderByCond();
        return new PageInfo(orders);
    }
}
