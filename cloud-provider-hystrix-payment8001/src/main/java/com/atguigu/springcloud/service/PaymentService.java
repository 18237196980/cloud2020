package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.ComResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.naming.Name;

@Service
public class PaymentService {

    public ComResult getPaymentOK(Long id) {
        return new ComResult(200, "请求成功:id" + id, "线程:" + Thread.currentThread()
                                                                .getName());
    }

    /**
     * 服务端服务降级
     *
     * @param id
     * @return
     */
    /*@HystrixCommand(fallbackMethod = "backMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    public ComResult getPaymentTimeOut(Long id) {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // int aa = 10 / 0;
        return new ComResult(200, "请求TimeOut:id" + id, "线程:" + Thread.currentThread()
                                                                     .getName());
    }

    // fallbackMethod
    private ComResult backMethod(Long id) {
        return new ComResult(-1, "请求异常，回复此信息");
    }

}
