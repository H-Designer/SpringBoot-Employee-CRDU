package com.example.config;

import com.example.filter.MyFilter;
import com.example.listener.MyListener;
import com.example.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet servlet=new MyServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet,"/myservlet");
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean fileRegistrationBean = new FilterRegistrationBean();
        fileRegistrationBean.setFilter(new MyFilter());
        fileRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return fileRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean= new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
        }


    //配置servlet容器
//    @Bean  //一定要将这个定制器加入到容器中
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//
//            //定制嵌入式的Servlet容器相关的规则
//            @Override
    //设置访问端口，但是没成功，SpringBoot的版本升级已经弃用这种方法
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setPort(8083);
//            }
//        };
//    }

}
