package com.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerApplication
 * SpringBootApplication默认扫描CustomerApplication所在包所以需要scanBasePackages制定包名
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.lab"})
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    @RequestMapping("/ping")
    public String index() {
        return "alive";
    }
}
