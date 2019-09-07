package com.dagon.microservice2017.restonspringwebmvc.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dagon on 2019/9/7 - 20:04
 */
@RestControllerAdvice
public class RestDemoController {

    @ExceptionHandler(NullPointerException.class)
    public Object handNPE(Throwable throwable){

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", throwable.getMessage());
        resultMap.put("stack", throwable.getCause());

        return resultMap;
    }


}
