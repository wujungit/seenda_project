package com.seenda.business.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.seenda.component.feign.service"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.seenda.business.api", "com.seenda.component.feign"})
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
