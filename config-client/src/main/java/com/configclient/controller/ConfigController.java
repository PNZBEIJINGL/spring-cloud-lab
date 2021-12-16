package com.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    //绑定配置
    @Value("${from}")
    private String from;

    @Autowired
    private Environment env;

    @RequestMapping("/fromByConf")
    public String from(){
        return this.from;
    }
    @RequestMapping("/fromByEnv")
    public String getFromByEnv(){
        return this.env.getProperty("from","undefined");
    }
}
