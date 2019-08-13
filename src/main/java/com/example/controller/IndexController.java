package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    //     这是通过控制请求，在地址栏中没有请求的时候，也跳到我们想要的页面，而不是通过springboot的首址映射直接跳到index页面
    @RequestMapping({"/","index.html"})
    public String index(){
        return "login";
    }

}
