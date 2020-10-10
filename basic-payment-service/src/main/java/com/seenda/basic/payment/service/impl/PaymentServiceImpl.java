package com.seenda.basic.payment.service.impl;

import com.seenda.basic.payment.dao.PaymentMapper;
import com.seenda.basic.payment.entity.Payment;
import com.seenda.basic.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment selectById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertPayment(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Integer updatePayment(Payment payment) {
        return paymentMapper.updateByPrimaryKeySelective(payment);
    }

    @Override
    public Integer deletePaymentById(Long id) {
        return paymentMapper.deleteByPrimaryKey(id);
    }

}
