package com.itheima.filter;

import com.itheima.util.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //1.获取请求url。
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if (url.contains("login")) {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //3.获取请求头中的令牌（token）。
        String token = request.getHeader("token");
        //4.判断令牌是否存在，如果不存在，响应401。
        if (StringUtils.isEmpty(token)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //5.解析token，如果解析失败，响应401 。
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //6.放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
