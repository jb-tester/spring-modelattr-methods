package com.mytests.springmvc.springmodelattrmethods;

/**
 * *
 * <p>Created by irina on 24.11.2020.</p>
 * <p>Project: spring-modelattr-methods</p>
 * *
 */
public class Foo2 implements FooService {
    private final String fooStr;
    private final long id;

    public Foo2(String fooStr, long id) {
        this.fooStr = fooStr+"_2";
        this.id = id;
    }

    public String getFooStr() {
        return fooStr;
    }

    public long getId() {
        return id;
    }

}
