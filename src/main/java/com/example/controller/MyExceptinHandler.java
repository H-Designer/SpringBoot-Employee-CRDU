package com.example.controller;

import com.example.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptinHandler {
    //1.浏览器客户端返回的全是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String ,Object> handleException(Exception e){
//        Map<String ,Object> map=new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("massage",e.getMessage());
//        return map;
//    }


    //2.转发到/error进行自适应效果进行处理
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //转发到/error
        return "forward:/error";
    }
}
