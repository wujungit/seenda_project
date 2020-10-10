package com.seenda.component.feign.service;

import com.seenda.basic.common.vo.payment.PaymentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "basic-payment-service", fallback = PaymentFeignServiceFallbackFactory.class)
public interface PaymentFeignService {

    @GetMapping("/payment/findPaymentById/{id}")
    public PaymentVO findPaymentById(@PathVariable("id") Long id);

}
