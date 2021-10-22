package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient //将应用注册为Eureka客户端应用，激活Eureke中DiscoverClient实现，获得服务发现的能力
@SpringBootApplication(scanBasePackages = {"com.customer"})
public class CustomerApplication {

    public static void main(String[] args) {
        System.out.println("Customer：http://127.0.0.1:8001/");
        SpringApplication.run(CustomerApplication.class, args);
    }


}
