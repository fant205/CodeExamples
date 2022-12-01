package ru.learn.security.controller;

import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_ADMIN")
    public String getAdminPage(){
        return "admin-page";
    }

    @GetMapping("/user-page")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String getUserPage(){
        return "user-page";
    }

    @GetMapping("/guest")
    public String getGuestPage(){
        return "guest page";
    }

    /**
     * Если не указать нигде ограничения на некоторый путь, то он по умолчанию будет доступен, т.е. то что не описано, станет по умолчанию доступно всем
     * @return
     */
    @GetMapping("/nobody")
    public String getNobody(){
        return "nobody";
    }

}
