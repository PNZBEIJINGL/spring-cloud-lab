package com.customer.service;


import com.customer.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
public interface ICustomerService {

    //测试
    @RequestMapping("/ping")
    public String ping();

    //根据ID获取客户信息
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public CustomerDTO getCustomerById(@PathVariable("id") Long id) throws InterruptedException;

    //保存客户信息
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) throws InterruptedException;
}
