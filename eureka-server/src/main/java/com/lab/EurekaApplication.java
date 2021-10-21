package com.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @EnableEurekaServer注解激活Eureka中的DiscouverClient实现
 * @SpringBootApplication默认扫描CustomerApplication所在包所以需要scanBasePackages制定包名
 */
//@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
    }
}
