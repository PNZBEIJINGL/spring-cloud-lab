package com.springcloud.test.feignconsumer.server;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceFallback implements CustomerService {


    @Override
    public String time() {
        return "请求失败";
    }

    @Override
    public String getCustomerById(Long id) {
        return "请求失败";
    }
}
