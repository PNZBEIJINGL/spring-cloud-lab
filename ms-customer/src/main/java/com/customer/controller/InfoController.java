package com.customer.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class InfoController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * http://127.0.0.1:1111/info/
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String into() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String message = " host:" + instance.getHost() + ",service_id:" + instance.getServiceId();
        logger.info(message);

        return  message+" Time:"+new Date().toString();
    }
}
