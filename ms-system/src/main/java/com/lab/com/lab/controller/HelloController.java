package com.lab.com.lab.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {

    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance serviceInstance=client.getLocalServiceInstance();
        System.out.println("/hello host:"+serviceInstance.getHost()+"|"+serviceInstance.getServiceId());
        return "Hello";
    }
}
