package com.example.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web项目启动");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web项目关闭");
    }
}
