package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.ComResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentForBackService implements PaymentFeignService {
    @Override
    public ComResult getPaymentOK(Long id) {
        return new ComResult(-101, "服务端出问题啦");
    }

    @Override
    public ComResult getPaymentTimeOut(Long id) {
        return new ComResult(-101, "服务端出问题啦");
    }
}
