package com.dillip.learn.springboot.helloworld;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String helloWorld) {

        this.message=helloWorld;

    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }
}
