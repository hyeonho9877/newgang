package com.LKS.newgang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/home")
    public String getHome(){
        return "Hello World!";
    }
}