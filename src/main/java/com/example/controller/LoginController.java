package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
//    @RequestParam ("username") String Username,根绝从login网页中传入的值进行数据的接收
//    @RequestParam ("password")String Password,
    public String login(@RequestParam ("username") String Username,
                        @RequestParam ("password")String Password,
                        Map<Object,String> map, HttpSession session){
        //登陆成功
        if(!StringUtils.isEmpty(Username)&&Password.equals("123")) {
            session.setAttribute("loginusername",Username);
            return  "redirect:/main.html";
        }
        //登录失败
        else{
            map.put("mes","用户名密码错误");
            return  "login";
        }
    }
}
