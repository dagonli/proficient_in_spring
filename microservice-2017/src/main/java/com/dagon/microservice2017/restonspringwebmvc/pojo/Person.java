package com.dagon.microservice2017.restonspringwebmvc.pojo;

/**
 * Created by Dagon on 2019/9/6 - 21:27
 */
public class Person {
    private long id;
    private String name;

    public Person() {
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
