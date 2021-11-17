package com.springcloud.test.feignconsumer.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MS-CUSTOMER",fallback = CustomerServiceFallback.class)
public interface CustomerService {

    //不带参数
    @RequestMapping("/time")
    public String time() ;

    //带参数
    @RequestMapping(value = "/customer/{id}" ,method = RequestMethod.GET)
    public String getCustomerById(@RequestParam("id") Long id);
}
