package com.seenda.business.core.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.seenda.basic.common.base.BaseResult;
import com.seenda.basic.common.vo.payment.PaymentVO;
import com.seenda.component.feign.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/core")
@Slf4j
//@DefaultProperties(defaultFallback = "fallback", commandProperties = @HystrixProperty(
//        name = "execution.isolation.thread.timeoutInMilliseconds",
//        value = "4000"
//))
public class CoreController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/feign/findPaymentById/{id}")
//    @HystrixCommand
//    @HystrixCommand(
//            fallbackMethod = "findPaymentByIdFallback",
//            commandProperties = {
//                    @HystrixProperty(
//                            name = "execution.isolation.thread.timeoutInMilliseconds",
//                            value = "8000"
//                    )
//            }
//    )
    public BaseResult feignFindPaymentById(@PathVariable("id") Long id) {
        PaymentVO vo = paymentFeignService.findPaymentById(id);
        return BaseResult.buildSuccess("查询成功！", vo);
    }

    public BaseResult findPaymentByIdFallback(Long id) {
        return BaseResult.buildFailure("系统异常，请稍后重试", id);
    }

    @GetMapping("/findPaymentById/{id}")
    public BaseResult findPaymentById(@PathVariable("id") Long id) {
        log.info("id: {}", id);
        PaymentVO vo = restTemplate.getForObject(
                "http://basic-payment-service/payment/findPaymentById/1", PaymentVO.class);
        return BaseResult.buildSuccess("查询成功！", vo);
    }

    @GetMapping("/discovery")
    public BaseResult discovery() {
        List<String> services = discoveryClient.getServices();
        log.info("services: {}", services.toString());
        List<ServiceInstance> instances = discoveryClient.getInstances("basic-payment-service");
        return BaseResult.buildSuccess("查询成功！", instances);
    }

    public BaseResult fallback() {
        return BaseResult.buildFailure("系统异常，请联系后台爸爸", null);
    }

}
