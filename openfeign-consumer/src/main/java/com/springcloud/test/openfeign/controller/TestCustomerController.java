package com.springcloud.test.openfeign.controller;

import com.springcloud.test.openfeign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCustomerController {
    @Autowired
    private CustomerService customerService;

    //http://127.0.0.1:8004/openfeign/gettime
    @RequestMapping(value = "/openfeign/gettime",method = RequestMethod.GET)
    public String testMSCustomer(){
        return customerService.time();
    }

    //http://127.0.0.1:8004/openfeign/getcustomer
    @RequestMapping(value = "/openfeign/getcustomer", method = RequestMethod.GET)
    public String  testGetCustomerName(){
        return customerService.getCustomerById(999L);
    }
}
