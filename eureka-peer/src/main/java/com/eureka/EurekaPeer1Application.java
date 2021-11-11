package com.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 *
 * @EnableEurekaServer注解激活Eureka中的DiscouverClient实现
 * @SpringBootApplication默认扫描CustomerApplication所在包所以需要scanBasePackages制定包名
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaPeer1Application {

    public static void main(String[] args) {
        System.out.println("服务注册中心：http://127.0.0.1:1000/");
        new SpringApplicationBuilder(EurekaPeer1Application.class).web(true).run(args);
    }
}
