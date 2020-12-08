package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(required = false) String operation, int x, int y){
        if (operation.equals("subtract")) {
            return x + " - " + y + " = " + (x - y);
        } else if (operation.equals("multiply")) {
            return x + " * " + y + " = " + (x * y);
        } else if (operation.equals("divide")) {
            return x + " / " + y + " = " + (x / y);
        }else {
            return x + " + " + y + " = " + (x + y);
        }
    }

    @GetMapping("/math/calculate2")
    public String calculate2(@RequestParam(defaultValue = "add") String operation, @RequestParam int x,@RequestParam int y){
        return MathService.calculate(operation, x, y).toString();
    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam Integer[] n){
        return MathService.sum(n).toString();
    }
}
