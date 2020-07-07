package com.cjw.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ServicesApplication
 * @Description
 * @Date 2020/7/7 10:35
 * @Created by cjw
 */
/*
* 可以用@SpringCloudApplication代替下面的注解
* */
@SpringBootApplication
@EnableDiscoveryClient //eureka客户端
@EnableCircuitBreaker //开启熔断

@EnableFeignClients //消费方要加这注解
public class ServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
