package com.asiainfo.service.impl;

import com.asiainfo.mapper.TestOrderMapper;
import com.asiainfo.model.TestOrder;
import com.asiainfo.service.ITestPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Version 1.0
 * @Author cxl
 * @date 2020/8/12 11:38
 */
@Slf4j
@Service
public class TestPort implements ITestPort {
    @Autowired
    private TestOrderMapper orderMapper;

    @Override
    public String forTerminal(String testStr) {
        return "调用fn_service成功，fn_terminal参数为："+testStr;
    }

    @Override
    public TestOrder queryOrderDetailByService(String orderId) {
        log.info("订单详情查询Service, 订单ID:{}", orderId);
        return orderMapper.selectByPrimaryKey(orderId);
    }

}
