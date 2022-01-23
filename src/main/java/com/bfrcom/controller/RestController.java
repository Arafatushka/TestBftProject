package com.bfrcom.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("hi")
    public String hi(){
        return "hi!";
    }
}
