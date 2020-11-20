package com.study.springcloud.service;

/**
 * @author wang
 * @create 2020-11-19-16:26
 */
public interface PaymentService {

    // 成功
    public String paymentInfo_OK(Integer id);

    // 失败
    public String paymentInfo_TimeOut(Integer id);

    // 服务熔断
    public String paymentCircuitBreaker(Integer id);

}
