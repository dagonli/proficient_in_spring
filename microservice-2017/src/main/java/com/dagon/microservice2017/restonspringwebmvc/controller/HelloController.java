package com.dagon.microservice2017.restonspringwebmvc.controller;

import com.dagon.microservice2017.restonspringwebmvc.pojo.Person;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dagon on 2019/9/6 - 21:29
 *
 *
 * 当使用Post请求时，请求时需要增加Content-Type（比如：application/json），后台需要对应的HttpMessageConverter
 * (比如：MappingJackson2HttpMessageConverter)，不然会报错(e.g. Content type 'text/plain' not supported)
 *
 * 使用Get请求时，则不需要，url传参，后台可直接解析。
 *
 *
 */
@RestController
public class HelloController {

    @GetMapping("/hello/{id}")
    public Person hello(@PathVariable Long id, @RequestParam(required = false) String name){
        return new Person(id, name);
//        return "Hello,DagonLi";
    }


    /**
     * @param person
     * @return
     */
    @PostMapping(value = "/person/json/properties"
//            ,
//        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = "application/properties+person;charset=UTF-8"
    )
    public Person properties(@RequestBody Person person){
        return new Person(123,"666");
    }

    @PostMapping(value = "/person/properties/json"
//            ,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            consumes = "application/properties+person;charset=UTF-8"
    )
    public Person json(@RequestBody Person person){
        return new Person(123,"666");
    }
}
