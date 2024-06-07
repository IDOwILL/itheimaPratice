package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;
import com.itheima.pojo.Result;
import com.itheima.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperateLogController {
    @Autowired
    private OperateLogService operateLogService;
    @RequestMapping("/log/page")
    public Result queryLog(PageParem param) {
        PageBean pageBean = operateLogService.queryLog(param);
        return Result.success(pageBean);
    }
}
