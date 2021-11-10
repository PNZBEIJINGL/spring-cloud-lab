package com.customer.controller;

import com.customer.CustomerDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController()
@RequestMapping(path = "/customer")
public class CustomerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * http://127.0.0.1:8001/customer/name/1
     */
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
    public String getCustomerName(@PathVariable("id") Long customerId) throws InterruptedException {
        //测试阻塞几秒
        int sleepTime=new Random().nextInt(3000);
        Thread.sleep(sleepTime);

        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String message = " host:" + instance.getHost() + ",service_id:" + instance.getServiceId()+ " "+sleepTime;
        logger.info(message);

        CustomerDTO customer = mockCustomer();
        return customer.getName();
    }

    /**
     * http://127.0.0.1:8001/customer/1
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomerDTO getCustomer(@PathVariable("id") Long customerId) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String message = " host:" + instance.getHost() + ",service_id:" + instance.getServiceId();
        logger.info(message);

        CustomerDTO customer = mockCustomer();
        return customer;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(CustomerDTO customerDTO) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String message = " host:" + instance.getHost() + ",service_id:" + instance.getServiceId() + "<br> add Customer OK";
        logger.info(message);

        return message;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable("id") Long customerId) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String message = " host:" + instance.getHost() + ",service_id:" + instance.getServiceId() + "<br> delete Customer OK";
        logger.info(message);

        return message;
    }

    private CustomerDTO mockCustomer() {
        CustomerDTO customer = new CustomerDTO();
        customer.setId(1000L);
        customer.setCode("1000");
        customer.setName("zhangsan");
        return customer;
    }
}
