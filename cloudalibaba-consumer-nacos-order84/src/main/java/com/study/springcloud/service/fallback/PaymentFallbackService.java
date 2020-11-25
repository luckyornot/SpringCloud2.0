package com.study.springcloud.service.fallback;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author wang
 * @create 2020-11-24-15:56
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,
                "服务降级返回，---PaymentFallbackService",
                new Payment(id, "errorSerial"));
    }
}
