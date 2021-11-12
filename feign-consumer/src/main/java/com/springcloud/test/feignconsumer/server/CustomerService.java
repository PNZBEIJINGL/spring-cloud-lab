package com.springcloud.test.feignconsumer.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("MS-CUSTOMER")
public interface CustomerService {

    @RequestMapping("/time")
    public String time() ;
}
