package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.ComResult;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping("/pay/getSleep/{id}")
    public ComResult getPaymentTimeOut(@PathVariable("id") Long id) {
        log.info("并发请求sleep---:" + Thread.currentThread()
                                         .getName());
        return paymentService.getPaymentTimeOut(id);
    }

    @RequestMapping("/pay/get/{id}")
    public ComResult getPaymentOK(@PathVariable("id") Long id) {
        return paymentService.getPaymentOK(id);
    }

}
