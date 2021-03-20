package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.ComResult;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    DiscoveryClient discoveryClient;

    @RequestMapping("/pay/getSleep/{id}")
    public ComResult getSleep(@PathVariable("id") Long id) {
        /*try {
            log.info("并发请求---:" + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("并发请求---:" + Thread.currentThread()
                                    .getName());
        return new ComResult(200, "查询成功: " + id);
    }

    @RequestMapping("/pay/get/{id}")
    public ComResult getById(@PathVariable("id") Long id) {
        Map<String, Object> payment = paymentService.getById(id);
        return new ComResult(200, "查询成功: " + serverPort, payment);
    }

    @RequestMapping("/getEurekaService")
    public ComResult getEurekaService() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("hservice:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance:" + instance.getHost() + "---" + instance.getUri());
        }

        return new ComResult(200, "查询成功: " + serverPort, instances);
    }

}
