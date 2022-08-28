package com.example.lab3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathService {


    @GetMapping("/add/{num1}/{num2}")
    public String add(@PathVariable double num1, @PathVariable double num2) {
        return String.valueOf(num1 + num2);
    }

    @GetMapping("/minus/{num1}/{num2}")
    public String minus(@PathVariable double num1, @PathVariable double num2){
        return String.valueOf(num1 - num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam double num1, @RequestParam double num2) {
        return String.valueOf(num1 * num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam double num1, @RequestParam double num2){
        return  String.valueOf(num1/num2);
    }

}
