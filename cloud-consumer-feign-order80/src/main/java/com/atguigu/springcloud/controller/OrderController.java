package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.common.ComResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @RequestMapping("/consumer2/get/{id}")
    public ComResult getById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }
}
