package com.auguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWay9527Application {
    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Application.class, args);
    }

}
