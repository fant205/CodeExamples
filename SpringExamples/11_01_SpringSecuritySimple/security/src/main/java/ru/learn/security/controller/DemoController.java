package ru.learn.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class DemoController {


    @GetMapping("/home")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/admin-page")
    public String getAdminPage(){
        return "admin-page";
    }

    @GetMapping("/user-page")
    public String getUserPage(){
        return "user-page";
    }

    @GetMapping("/guest")
    public String getGuestPage(){
        return "guest page";
    }

    @GetMapping("/nobody")
    public String getNobody(){
        return "nobody";
    }

}
