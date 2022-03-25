package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class TestController3 {
    @GetMapping("/index")
    public User index(){
        return new User(100,"1234567","19380504129",new Date());
    }

}
