package com.dillip.learn.springboot.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping( path="hello-world")
    public String hellowWorld(){

        return "Hello World";
    }

    @GetMapping( path="hello-world-bean")
    public HelloWorldBean hellowWorldBean(){

        return new HelloWorldBean("Hello World");
    }

    @GetMapping( path="hello-world/path-variable/{name}")
    public HelloWorldBean hellowWorldPathVariable(@PathVariable String name){

        return new HelloWorldBean(String.format("Hellow World, %s",name));
    }


}
