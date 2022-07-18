package com.axel.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class FooController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/foo")
    public Foo greeting(@RequestParam(value = "name", defaultValue = "Rest") String name) {
        return new Foo(counter.incrementAndGet(), String.format(template, name));
    }
}
