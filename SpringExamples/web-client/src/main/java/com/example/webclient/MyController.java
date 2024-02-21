package com.example.webclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api/v1/my")
public class MyController {
    @GetMapping
    public String find() {
        return "Hi all!";
    }

}