package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${my.param}")
    private String string;

//    @PostConstruct
//    public void init(){
//        System.out.println(string);
//    }

    @GetMapping("/hello")
    public String hello() {
        return "Config: " + string;
    }

}