package com.seenda.basic.order.service;

import com.seenda.basic.order.entity.Order;

public interface OrderService {

    Order selectById(Long id);

    Integer insertPayment(Order order);

    Integer updatePayment(Order order);

    Integer deletePaymentById(Long id);

}
