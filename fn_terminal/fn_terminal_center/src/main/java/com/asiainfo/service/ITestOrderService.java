package com.asiainfo.service;

import com.asiainfo.model.TestOrder;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Description 订单服务接口类（示例）
 * @Version 1.0
 * @Author cxl
 * @date 2020/8/11 11:29
 */
public interface ITestOrderService {

    /**
     * 生成订单
     *
     * @param order 订单信息类
     * @return
     */
    boolean createTestOrder(TestOrder order);

    /**
     * 根据订单编码查询订单详情
     *
     * @param orderId
     * @return 订单详情
     */
    TestOrder queryTestOrder(String orderId);

    /**
     * 根据条件分页查询订单
     *
     * @param cond
     * @param pageSize 每页记录条数
     * @param currPage 当前页
     * @return
     */
    @SuppressWarnings("rawtypes")
    public PageInfo queryTestOrderByPage(Map<String, Object> cond, int pageSize, int currPage);

}
