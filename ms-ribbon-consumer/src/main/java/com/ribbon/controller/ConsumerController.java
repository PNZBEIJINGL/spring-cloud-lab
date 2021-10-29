package com.ribbon.controller;

import com.customer.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试ResultTemplate POST 请求
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;


    /**
     * http://127.0.0.1:8002/ribbon-consumer-add1
     *
     * @return
     * @restTemplate.getForEntity 重载1测试
     */
    @RequestMapping(value = "/ribbon-consumer-add1", method = RequestMethod.GET)
    public String addCustomer1() {

        CustomerDTO customerDTO = mockCustomer();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity
                ("http://MS-CUSTOMER/customer/add", customerDTO, String.class);
        return responseEntity.getBody();
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-add2
     *
     * @return
     * @restTemplate.getForEntity 重载2测试
     */
    @RequestMapping(value = "/ribbon-consumer-add2", method = RequestMethod.GET)
    public String addCustomer2() {
        CustomerDTO customerDTO = mockCustomer();
        String str = restTemplate.postForObject
                ("http://MS-CUSTOMER/customer/add", customerDTO, String.class);
        return str;
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-add3
     *
     * @return
     * @restTemplate.getForEntity 重载3测试
     */
    @RequestMapping(value = "/ribbon-consumer-add3", method = RequestMethod.GET)
    public String addCustomer3() {
        CustomerDTO customerDTO = mockCustomer();
        URI responseURI = restTemplate.postForLocation("http://MS-CUSTOMER/customer/add", customerDTO);
        return "OK";
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-delete
     *
     * @return
     * @restTemplate.getForEntity 重载3测试
     */
    @RequestMapping(value = "/ribbon-consumer-delete", method = RequestMethod.GET)
    public String delete() {
        Long customerId=1000L;
        restTemplate.delete("http://MS-CUSTOMER/customer/delete/{1}",customerId);
        return "DELETE OK";
    }

    private CustomerDTO mockCustomer() {
        CustomerDTO customer = new CustomerDTO();
        customer.setId(1000L);
        customer.setCode("1000");
        customer.setName("zhangsan");
        return customer;
    }

}
