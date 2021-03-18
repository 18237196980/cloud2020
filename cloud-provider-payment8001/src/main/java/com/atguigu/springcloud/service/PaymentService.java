package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

import java.util.Map;

public interface PaymentService {
    Map<String,Object> getById(Long id);
}
