package com.eureka.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class InfoController {

    /**
     * http://127.0.0.1:1000/info/
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String into() {

        return new Date().toString();
    }


}
