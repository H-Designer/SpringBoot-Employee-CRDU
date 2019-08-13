package com.example.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 登陆拦截器
* */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //在目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginusername");
        if(user == null){
            //未登录，进行拦截，返回登陆界面
            request.setAttribute("mes","没有权限请先进行登陆操作");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else {
            //已登录，放行
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
