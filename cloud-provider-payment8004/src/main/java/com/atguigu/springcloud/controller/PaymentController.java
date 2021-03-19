package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.ComResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @RequestMapping("/pay/get")
    public ComResult getById() {
        return new ComResult(200, "查询成功: " + UUID.randomUUID()
                                                 .toString());
    }

}
