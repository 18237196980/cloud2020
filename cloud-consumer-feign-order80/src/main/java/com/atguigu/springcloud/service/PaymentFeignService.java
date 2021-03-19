package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.ComResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @RequestMapping("/pay/get/{id}")
    public ComResult getById(@PathVariable("id") Long id);
}
