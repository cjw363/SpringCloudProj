package com.cjw.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname EurekaRegistryApplication
 * @Description
 * @Date 2020/7/7 13:32
 * @Created by cjw
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistryApplication.class);
    }

}
