package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


//@WebFilter("/*")
public class DemoFilter implements Filter {
    /**
     * 项目启动的时候只会被执行一次
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter方法执行了");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("doFilter方法执行了");
    }

    @Override
    public void destroy() {
        System.out.println("毁灭方法执行了");
    }
}
