package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.common.ComResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @DefaultProperties(defaultFallback = "backMethod") // 全局Fallback
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @RequestMapping("/consumer/get/{id}")
    public ComResult getById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentOK(id);
    }

    @RequestMapping("/consumer/getSleep/{id}")
    public ComResult getSleep(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentTimeOut(id);
    }

    /**
     * 客户端服务降级
     *
     * @param id
     * @return
     */
    /*@HystrixCommand(fallbackMethod = "backMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })*/
    // @HystrixCommand
    @RequestMapping("/consumer/getPaymentTimeOut/{id}")
    public ComResult getPaymentTimeOut(@PathVariable("id") Long id) {
        // int aa = 10 / 0;
        return paymentFeignService.getPaymentTimeOut(id);
    }

    public ComResult backMethod(Long id) {
        return new ComResult(-1, "请求异常，回复此信息");
    }
}
