package com.study.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wang
 * @create 2020-11-19-19:06
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {

        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {

        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";

    }
}
