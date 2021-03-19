package com.atguigu.com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义随机 负载均衡策略
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule loadRule(){
        return new RandomRule();
    }
}
