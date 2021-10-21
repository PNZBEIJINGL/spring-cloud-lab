package com.lab.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    private final Logger logger=Logger.getLogger(getClass());


    //@Autowired
    //private DiscoveryClient client;

    @RequestMapping(value="/ping",method = RequestMethod.GET)
    public String index(){
       // ServiceInstance instance=client.getLocalServiceInstance();
       // logger.info("host:"+instance.getHost()+" ,service_id"+instance.getServiceId());
        return LocalDateTime.now().toString();
    }


}
