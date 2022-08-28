package com.example.lab3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GeneratePasswordService {
    @GetMapping("{name:[A-z]+}.generate")
    public String generate(@PathVariable String name) {
        int pwd = (int)( Math.pow(10, 9) * Math.random());
        return "Hi," + name + "\nYour password is " + pwd;
    }
}
