package com.itheima.config;

import com.itheima.incepector.LoginIncepector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginIncepector loginIncepector;
//不在这里进行注册过滤器是没法使用的
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIncepector).addPathPatterns("/**").excludePathPatterns("/login","/login.html");
    }
}
