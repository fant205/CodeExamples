package ru.test.axel.rest;


import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/get")
    public List<Foo> get() {
        return Arrays.asList(
                new Foo(1, "Hi 1"),
                new Foo(2, "Hi 2"),
                new Foo(3, "Hi 3")
        );
    }
}
