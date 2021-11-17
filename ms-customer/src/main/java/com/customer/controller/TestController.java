package com.customer.controller;

import com.customer.CustomerDTO;
import com.customer.service.ICustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;


@RestController
public class TestController implements ICustomerService {

    @Override
    public String ping() {
        return new Date().toString();
    }

    @Override
    public CustomerDTO getCustomerById(@PathVariable("id") Long id) throws InterruptedException {
        //测试阻塞几秒
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);

        CustomerDTO customer = mockCustomer();
        customer.setId(id);
        return customer;
    }

    @Override
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) throws InterruptedException {
        //测试阻塞几秒
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);

        CustomerDTO customer = customerDTO;
        return customer;
    }

    private CustomerDTO mockCustomer() {
        CustomerDTO customer = new CustomerDTO();
        customer.setId(1000L);
        customer.setCode("1000");
        customer.setName("zhangsan");
        return customer;
    }
}
