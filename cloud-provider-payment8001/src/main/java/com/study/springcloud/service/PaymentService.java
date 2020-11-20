package com.study.springcloud.service;

import com.study.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wang
 * @create 2020-11-16-21:33
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
