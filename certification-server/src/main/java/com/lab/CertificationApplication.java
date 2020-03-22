package com.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(scanBasePackages = {"com.lab"})
public class CertificationApplication {

    public static void main(String[] args) {

        SpringApplication.run(CertificationApplication.class, args);
    }

    @RequestMapping("/ping")
    public String index() {
        return "alive";
    }
}
