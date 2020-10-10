package com.seenda.basic.payment.controller;

import com.seenda.basic.common.dto.payment.PaymentDTO;
import com.seenda.basic.common.vo.payment.PaymentVO;
import com.seenda.basic.payment.entity.Payment;
import com.seenda.basic.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/findPaymentById/{id}")
    public PaymentVO findPaymentById(@PathVariable("id") Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentService.selectById(id);
        PaymentVO vo = new PaymentVO();
        vo.setId(payment.getId());
        vo.setSerial(payment.getSerial());
        return vo;
    }

    @PostMapping("/addPayment")
    public void addPayment(@RequestBody PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setId(dto.getId());
        payment.setSerial(dto.getSerial());
        paymentService.insertPayment(payment);
    }

    @PutMapping("/modifyPayment")
    public void modifyPayment(@RequestBody PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setId(dto.getId());
        payment.setSerial(dto.getSerial());
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/removePayment/{id}")
    public void removePayment(@PathVariable("id") Long id) {
        paymentService.deletePaymentById(id);
    }

}
