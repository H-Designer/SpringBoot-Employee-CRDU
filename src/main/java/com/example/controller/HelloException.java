package com.example.controller;

import com.example.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloException {
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String User){
        if(User.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello word";
    }
}
