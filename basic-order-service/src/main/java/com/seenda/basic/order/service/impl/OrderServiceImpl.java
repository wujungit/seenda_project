package com.seenda.basic.order.service.impl;

import com.seenda.basic.order.dao.OrderMapper;
import com.seenda.basic.order.entity.Order;
import com.seenda.basic.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order selectById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertPayment(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Integer updatePayment(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Integer deletePaymentById(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

}
