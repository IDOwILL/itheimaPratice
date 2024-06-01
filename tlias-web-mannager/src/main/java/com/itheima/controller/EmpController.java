package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.EmpExprService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpExprService empExprService;


    /*   *//*    @GetMapping
        public Result queryPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
            PageBean pageBean = empService.queryPage(page, pageSize);
            return Result.success(pageBean);
        }*/
    @GetMapping
    public Result queryPage(EmpQueryParam param) {
        log.info("查询参数 - 姓名: {}, 性别: {}, 开始日期: {}, 结束日期: {}", param.getName(), param.getGender(), param.getBegin(), param.getEnd());
        PageBean pageBean = empService.queryPage(param);
        return Result.success(pageBean);
    }

    @PostMapping
    public Result saveEmp(@RequestBody Emp emp) {
        log.info(emp.toString());
        emp.setPassword("123456");
        empService.saveEmp(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Integer> ids) {
        log.info("删除的员工ids===》" + ids);
        empService.deleteByIds(ids);
        empExprService.deleteByIds(ids);
        return Result.success();
    }


    /**
     * 按id查询,编辑员工回显
     *
     * @return 后端统一返回结果
     */
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        Emp emp = empService.queryById(id);

        return Result.success(emp);
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        empService.updateEmp(emp);
        return Result.success();
    }


}
