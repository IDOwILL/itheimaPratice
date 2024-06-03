package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/log/page")
    public Result queryLog(PageParem param) {
        PageBean pageBean =logService.queryLog(param);
        return Result.success(pageBean);
    }
}
