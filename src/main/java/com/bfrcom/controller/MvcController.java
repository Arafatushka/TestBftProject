package com.bfrcom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("hi2")
    public String heello(){
        return "index";
    }
}
