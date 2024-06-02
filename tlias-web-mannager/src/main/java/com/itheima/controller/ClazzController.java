package com.itheima.controller;

import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理
 */
@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result queryString(ClazzQueryParam clazzQueryParam) {
        PageBean pageBean = clazzService.queryString(clazzQueryParam);
        log.info(pageBean.toString());
        return Result.success(pageBean);
        //分页查询都是PageBean对象
    }

    //这里报错类型转换异常是因为没有list方法，刷新会自动调用list方法
    @GetMapping("/list")
    //这个接口好像没有作用，离谱,更离谱的是这tm的是emp的，cao
    public Result queryList() {
        List<Clazz> clazzList = clazzService.queryList();
        return Result.success(clazzList);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result saveClazz(@RequestBody Clazz clazz) {//JSOn格式用@RequestBody

        clazzService.saveClazz(clazz);
        return Result.success();
    }

    //修改前的查询回显
    @GetMapping("/{id}")
    public Result queryInfoById(@PathVariable Integer id) {
        Clazz clazz=clazzService.queryInfoById(id);
        log.info(clazz.toString());
        return Result.success(clazz);
    }
//修改班级
    @PutMapping
    public Result updateClazz(@RequestBody  Clazz clazz) {
        clazzService.updateClazz(clazz);
        return Result.success();
    }

}
