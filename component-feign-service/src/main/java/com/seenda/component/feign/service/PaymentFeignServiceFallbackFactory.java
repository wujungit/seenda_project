package com.seenda.component.feign.service;

import com.seenda.basic.common.vo.payment.PaymentVO;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceFallbackFactory implements PaymentFeignService {
    @Override
    public PaymentVO findPaymentById(Long id) {
        return null;
    }
}
