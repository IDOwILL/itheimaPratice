package com.itheima.controller;


import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController//@RestController=@Controller+@ResponseBody
public class DeptController {

    @Autowired(required = true)
    private DeptService deptService;//面相接口编程

    /**
     * 获取全部部门
     *
     * @return 后端统一返回结果
     * @throws IOException IOException
     */

    @GetMapping
    public Result selectAll() throws IOException {
        List<Dept> list = deptService.getAll();
        return Result.success(list);
    }


    /**
     * 按id删除部门
     *
     * @param id 部门主键
     * @return 后端统一返回结果
     */
    @DeleteMapping
    @Log
    public Result deleteDeptById(@RequestParam("id") Integer id) {
        log.info("删除部门 " + id);
        deptService.deleteDeptById(id);
        return Result.success();
    }

    /**
     * 插入深度
     *
     * @param dept 名称
     * @return 后端统一返回结果
     */
    @PostMapping
    @Log
    public Result saveDept(@RequestBody Dept dept) {
        deptService.saveDept(dept);
        log.info("新增部门" + dept);
        return Result.success();
    }

    /**
     * 按id获取部门信息
     *
     * @param id 主键
     * @return 后端统一返回结果
     *///先查询回显，再修改内容
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id) {
        log.info("根据部门id查询部门信息" + id);
        Dept dept = deptService.getInfoById(id);
        if (dept==null) return Result.error("没有该部门");
        return Result.success(dept);
    }

    /**
     * 按id更新部门名称
     *
     * @param dept 部门对象
     * @return 后端统一返回结果
     */
    @Log
    @PutMapping
    public Result updateById(@RequestBody Dept dept) {
        deptService.updateById(dept);
        log.info("根据id修改部门" +dept.getId());
        return Result.success();
    }
}
