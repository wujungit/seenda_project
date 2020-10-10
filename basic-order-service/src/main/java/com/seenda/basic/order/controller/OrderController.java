package com.seenda.basic.order.controller;

import com.seenda.basic.order.entity.Order;
import com.seenda.basic.order.service.OrderService;
import com.seenda.basic.common.dto.order.OrderDTO;
import com.seenda.basic.common.vo.order.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findOrderById/{id}")
    public OrderVO findOrderById(@PathVariable("id") Long id) {
        Order order = orderService.selectById(id);
        OrderVO vo = new OrderVO();
        vo.setId(order.getId());
        vo.setSerial(order.getSerial());
        return vo;
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setSerial(dto.getSerial());
        orderService.insertPayment(order);
    }

    @PutMapping("/modifyOrder")
    public void modifyOrder(@RequestBody OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setSerial(dto.getSerial());
        orderService.updatePayment(order);
    }

    @DeleteMapping("/removeOrder/{id}")
    public void removeOrder(@PathVariable("id") Long id) {
        orderService.deletePaymentById(id);
    }

}
