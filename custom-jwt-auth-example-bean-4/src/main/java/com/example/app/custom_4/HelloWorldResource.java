package com.example.app.custom_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("test")
    public String test() {
        return "Test!";
    }

}
