package com.asiainfo.service;

import com.asiainfo.model.TestOrder;

public interface ITestPort {

    /**
     * 提供给fn_terminal工程使用
     * @param testStr
     * @return
     */
    public String forTerminal(String testStr);

    /**
     * 根据订单编码查询订单详情（fn_service对外接口）
     * @param orderId
     * @return 订单详情
     */
    public TestOrder queryOrderDetailByService(String orderId);
}
