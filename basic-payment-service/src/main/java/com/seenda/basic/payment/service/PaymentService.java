package com.seenda.basic.payment.service;

import com.seenda.basic.payment.entity.Payment;

public interface PaymentService {

    Payment selectById(Long id);

    Integer insertPayment(Payment payment);

    Integer updatePayment(Payment payment);

    Integer deletePaymentById(Long id);

}
