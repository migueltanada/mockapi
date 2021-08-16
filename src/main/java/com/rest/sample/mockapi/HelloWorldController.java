package com.rest.sample.mockapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET ,path = "/hello-world")
    // @GetMapping(path = "/hello-world")
    // public String helloWorld(){
    //     return "hello world";
    // }

    //hello-world-bean
    @GetMapping(path = "/hello-world")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world");
    }
    
}
