package com.cjw.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Classname ZuulApplication
 * @Description
 * @Date 2020/7/7 22:49
 * @Created by cjw
 */
@SpringBootApplication
@EnableZuulProxy //开启zuul网关
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
