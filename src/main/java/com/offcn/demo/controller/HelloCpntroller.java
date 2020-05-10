package com.offcn.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloCpntroller {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello-demo-deshi123";
    }
}
