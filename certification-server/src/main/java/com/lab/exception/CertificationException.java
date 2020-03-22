package com.lab.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注解验证角色和权限的话无法捕捉异常，从而无法正确的返回给前端错误信息，所以我加了一个类用于拦截异常
 */
@ControllerAdvice
public class CertificationException {

    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        return "没有通过权限验证！";
    }
}
