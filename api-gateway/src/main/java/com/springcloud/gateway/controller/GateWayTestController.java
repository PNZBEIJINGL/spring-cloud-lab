package com.springcloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayTestController {

    @RequestMapping("/local/serverinfo")
    public String serverInfo() {
        return "这里是api0-gateway";
    }
}
