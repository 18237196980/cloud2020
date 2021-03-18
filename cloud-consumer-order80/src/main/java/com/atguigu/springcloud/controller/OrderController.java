package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.common.ComResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/consumer/get/{id}")
    public ComResult getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "pay/get/" + id, ComResult.class);
    }
}
