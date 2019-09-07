package com.dagon.microservice2017.restonspringwebmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dagon on 2019/9/7 - 20:07
 */
@RestController
public class SpringWebMVCController {

    @GetMapping("/npe")
    public String npe(){
        throw new NullPointerException("故意抛出空指针异常");
    }

}
