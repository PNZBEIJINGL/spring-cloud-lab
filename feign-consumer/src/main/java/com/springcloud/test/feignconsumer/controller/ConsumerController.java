package com.springcloud.test.feignconsumer.controller;

import com.springcloud.test.feignconsumer.server.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private CustomerService customerService;

    //http://127.0.0.1:8003/feign-ping
    @RequestMapping(value = "/feign-ping",method = RequestMethod.GET)
    public String testMSCustomer(){
        return customerService.time();
    }

    //http://127.0.0.1:8003/feign-customer
    @RequestMapping(value = "/feign-customer", method = RequestMethod.GET)
    public String  testGetCustomerName(){
        return customerService.getCustomerById(999L);
    }
}
