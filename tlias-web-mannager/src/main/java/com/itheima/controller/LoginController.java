package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        LoginInfo loginInfo = empService.login(emp);
        if (loginInfo != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", loginInfo.getId());
            map.put("username", loginInfo.getUsername());
            String token = JwtUtils.generateJwt(map);
            loginInfo.setToken(token);
            return Result.success(loginInfo);
        }
        return Result.error("账号密码错误");
    }
}
