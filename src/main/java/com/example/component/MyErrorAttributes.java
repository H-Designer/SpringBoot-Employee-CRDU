package com.example.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import java.util.Map;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object>  maps =  super.getErrorAttributes(webRequest, includeStackTrace);
        maps.put("company","atguigu");
        return maps;
    }
}