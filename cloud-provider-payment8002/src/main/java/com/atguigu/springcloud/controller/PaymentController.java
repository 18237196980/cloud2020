package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.ComResult;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/pay/get/{id}")
    public ComResult getById(@PathVariable("id") Long id) {
        Map<String, Object> payment = paymentService.getById(id);
        return new ComResult(200, "查询成功: " + serverPort, payment);
    }

}
