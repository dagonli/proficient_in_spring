package com.dagon.microservice2017.restonspringwebmvc.config;

import com.dagon.microservice2017.restonspringwebmvc.http.message.PersonPropertiesAbstractGenericHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by Dagon on 2019/9/6 - 22:34
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.err.println("converters size:" + converters.size());
        converters.clear();

        converters.add(new PersonPropertiesAbstractGenericHttpMessageConverter());
         converters.add(new MappingJackson2HttpMessageConverter());
        //converters.add(new MappingJackson2XmlHttpMessageConverter());
    }
}
