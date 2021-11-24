package com.springcloud.test.openfeign.conf;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

//@Configuration
public class FooConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        //禁用 Feign Hystrix支持
        return Feign.builder();
    }
}
