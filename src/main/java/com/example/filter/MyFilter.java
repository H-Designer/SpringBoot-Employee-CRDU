package com.example.filter;
import javax.servlet.*;
import java.io.IOException;
public class MyFilter implements Filter {
    //filter的初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        }
    //Filter的过滤
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter proccess...");
        chain.doFilter(request,response);
    }
    //Filter的销毁
    @Override
    public void destroy() {
    }
}
