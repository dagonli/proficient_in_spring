package com.dagon.microservice2017.restonspringwebmvc;

import com.dagon.microservice2017.restonspringwebmvc.pojo.Person;
import org.junit.Test;
import org.springframework.lang.Nullable;

/**
 * Created by Dagon on 2019/9/7 - 20:22
 */
public class NullableTest {


    public void doSth(String name, @Nullable Integer id){
        Person person = new Person(id, name);
        System.out.println(person);
    }

    @Test
    public void test(){
        doSth("dagon",null);

    }
}
