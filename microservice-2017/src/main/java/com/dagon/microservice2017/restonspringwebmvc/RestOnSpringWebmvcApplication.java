package com.dagon.microservice2017.restonspringwebmvc;

import com.dagon.microservice2017.restonspringwebmvc.interceptor.MyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestOnSpringWebmvcApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(RestOnSpringWebmvcApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }
}
