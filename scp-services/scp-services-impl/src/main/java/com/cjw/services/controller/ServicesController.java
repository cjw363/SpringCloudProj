package com.cjw.services.controller;

import com.cjw.services.client.AuthClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Classname ServicesController
 * @Description
 * @Date 2020/7/7 10:38
 * @Created by cjw
 */
@Controller
@RequestMapping("services")
@DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class ServicesController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息

    @GetMapping(value = "hello")
    @ResponseBody
    public String run() {
        return "hello";
    }

    /**
     *  根据ip port调用服务
     * @return
     */
    @GetMapping(value = "getdata")
    @ResponseBody
    @HystrixCommand // 标记该方法需要熔断
    public String getData() {
        //1.这种方式不能加负载均衡 @LoadBalance
        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("scp-auth");
        // 因为只有一个Service-provider。所以获取第一个实例
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/auth/login";
        String result = restTemplate.getForObject(baseUrl, String.class);

        //2.通过服务名
        //各个微服务是以“主机名:服务名:端口”的形式注册到注册中心。当本地测试时，主机是同一个，为localhost，所以能找到主机并相互调用。当部署上线时，每个微服务运行在不同主机，主机名都各不相同
        //解决配置：eureka.instance.prefer-ip-address=true
        //eureka.instance.instance-id=ip地址:端口
//        String baseUrl = "http://scp-auth/auth/login";
//        String result = restTemplate.getForObject(baseUrl, String.class);
        return result;
    }

    @Autowired
    private AuthClient authClient;

    /**
     * feign 服务间调用
     * @return
     */
    @GetMapping(value = "getdata2")
    @ResponseBody
    @HystrixCommand // 标记该方法需要熔断
    public String getData2() {
        return authClient.login();
    }

    public String fallBackMethod(){
        return "(服务熔断)请求繁忙，请稍后再试！";
    }
}
