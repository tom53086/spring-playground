package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/bestDog")
    public String getBestDog(){
        return "Griffin, of course!";
    }

    @GetMapping("/math/pi")
    public String getPie() {
        return "3.141592653589793";
    }
}
