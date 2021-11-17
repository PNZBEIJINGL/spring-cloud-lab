package com.springcloud.test.feignconsumer.server;

import com.customer.service.ICustomerService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "MS-CUSTOMER")
public interface RefactorCustomerService extends ICustomerService {

}
