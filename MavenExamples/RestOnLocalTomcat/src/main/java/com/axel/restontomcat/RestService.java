package com.axel.restontomcat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

    @GetMapping("/get")
    public Foo get() {
        return new Foo(1, "Axel");
    }
}
