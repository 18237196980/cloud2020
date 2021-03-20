package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.ComResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentForBackService.class)
public interface PaymentFeignService {
    @RequestMapping("/pay/get/{id}")
    public ComResult getPaymentOK(@PathVariable("id") Long id);

    @RequestMapping("/pay/getSleep/{id}")
    public ComResult getPaymentTimeOut(@PathVariable("id") Long id);
}
