package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.common.ComResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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

    /**
     * 服务端服务熔断（例子:10s内连续请求10次，fallback达到60%,即直接熔断。然后连续请求成功，熔断会慢慢放开，直至链路正常）
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "backMethod", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 10s中内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 10s钟
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 10s钟内请求的fallback概率
    })
    public ComResult getPaymentBreak(Long id) {
        if (id < 0) {
            log.info("----------调用链路失败--------------");
            throw new RuntimeException("调用链路失败");
        }
        String uuid = IdUtil.simpleUUID();
        return new ComResult(200, "请求TimeOut:id" + id, "uuid:" + uuid);
    }

    // fallbackMethod
    private ComResult backMethod(Long id) {
        return new ComResult(-1, "请求异常，熔断器回复此信息");
    }

}
