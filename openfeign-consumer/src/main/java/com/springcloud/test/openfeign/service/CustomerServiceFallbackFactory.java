package com.springcloud.test.openfeign.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

//@Component
public class CustomerServiceFallbackFactory implements FallbackFactory<CustomerService> {

    @Override
    public CustomerService create(final Throwable cause) {
        return new CustomerService() {
            @Override
            public String time() {
                return "fallback:" + cause.getMessage();
            }

            @Override
            public String getCustomerById(Long id) {
                return "fallback:" + cause.getMessage();
            }
        };
    }

}
