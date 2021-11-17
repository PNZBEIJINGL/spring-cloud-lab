package com.springcloud.test.feignconsumer.controller;

import com.customer.CustomerDTO;
import com.springcloud.test.feignconsumer.server.RefactorCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorCustomerController {

    @Autowired
    private RefactorCustomerService refactorHelloService;

    //http://127.0.0.1:8003/pingcustomer
    @RequestMapping(value = "/pingcustomer", method = RequestMethod.GET)
    public String pingCustomer() {
        return refactorHelloService.ping();
    }

    //http://127.0.0.1:8003/getcustomer
    @RequestMapping(value = "/getcustomer", method = RequestMethod.GET)
    public CustomerDTO getCustomer() {
        try {
            return refactorHelloService.getCustomerById(800L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/savecustomer", method = RequestMethod.GET)
    public CustomerDTO saveCustomer() {
        try {
            CustomerDTO customer = new CustomerDTO();
            customer.setId(70L);
            customer.setCode("70");
            customer.setName("zhangsan");
            return refactorHelloService.addCustomer(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
