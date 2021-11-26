package com.springcloud.test.openfeign.service;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "MS-CUSTOMER")
//@FeignClient(name = "${customer.server.name}" ,fallback = CustomerService.CustomerServiceFallback.class)
@FeignClient(name = "${customer.server.name}" ,fallbackFactory  = CustomerService.CustomerServiceFallbackFactory.class)
public interface CustomerService {

    //不带参数
    @RequestMapping("/time")
    public String time() ;

    //带参数
    @RequestMapping(value = "/customer/{id}" ,method = RequestMethod.GET)
    public String getCustomerById(@RequestParam("id") Long id);

    /*
    @Component
    class CustomerServiceFallback implements CustomerService{

        @Override
        public String time() {
            return "fallback";
        }

        @Override
        public String getCustomerById(Long id) {
            return "fallback";
        }
    }
    */

    static class CustomerServiceFallbackFactory implements FallbackFactory<CustomerService> {

        @Override
        public CustomerService create(final Throwable cause) {
            return new CustomerService() {
                @Override
                public String time() {
                    return "fallback,cause:" + cause.getMessage();
                }

                @Override
                public String getCustomerById(Long id) {
                    return "fallback,cause:" + cause.getMessage();
                }
            };
        }

    }
}
