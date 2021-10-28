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

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * http://127.0.0.1:8002/ribbon-consumer-ping
     */
    @RequestMapping(value = "/ribbon-customer-ping", method = RequestMethod.GET)
    public String pingConsumer() {
        return restTemplate.getForEntity
                ("http://MS-CUSTOMER/info", String.class).getBody();
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-name
     *
     * @return
     */
    @RequestMapping(value = "/ribbon-consumer-name", method = RequestMethod.GET)
    public String getConsumerName() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity
                ("http://MS-CUSTOMER/customer/name/1", String.class, "1");
        return responseEntity.getBody();
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-1
     *
     * @return
     * @restTemplate.getForEntity 重载1测试
     */
    @RequestMapping(value = "/ribbon-consumer-1", method = RequestMethod.GET)
    public CustomerDTO getConsumer1() {
        ResponseEntity<CustomerDTO> responseEntity = restTemplate.getForEntity
                ("http://MS-CUSTOMER/customer/{1}", CustomerDTO.class, "1");
        CustomerDTO customerDT = responseEntity.getBody();
        return customerDT;
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-1
     *
     * @return
     * @restTemplate.getForEntity 重载2测试
     */
    @RequestMapping(value = "/ribbon-consumer-2", method = RequestMethod.GET)
    public CustomerDTO getConsumer2() {
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        ResponseEntity<CustomerDTO> responseEntity = restTemplate.getForEntity
                ("http://MS-CUSTOMER/customer/{id}", CustomerDTO.class, params);
        CustomerDTO customerDT = responseEntity.getBody();
        return customerDT;
    }

    /**
     * http://127.0.0.1:8002/ribbon-consumer-1
     *
     * @return
     * @restTemplate.getForEntity 重载3测试
     */
    @RequestMapping(value = "/ribbon-consumer-3", method = RequestMethod.GET)
    public CustomerDTO getConsumer3() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://MS-CUSTOMER/customer/{id}")
                .build().expand("1")
                .encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<CustomerDTO> responseEntity = restTemplate.getForEntity(uri, CustomerDTO.class);
        CustomerDTO customerDT = responseEntity.getBody();
        return customerDT;
    }

}