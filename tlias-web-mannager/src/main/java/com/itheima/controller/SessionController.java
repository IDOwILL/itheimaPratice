package com.itheima.controller;

import com.itheima.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@Slf4j
public class SessionController {
//生成cookie
    @GetMapping("/c1")
    public Result cookie(HttpServletResponse response) {
        response.addCookie(new Cookie("LoginUser", "itheima"));
        return Result.success();
    }
//获取cookie
    @GetMapping("/c2")
    public Result session(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().contains("LoginUser")) {
                log.info(cookie.getValue());
            }
        }
        return null;
    }
}
