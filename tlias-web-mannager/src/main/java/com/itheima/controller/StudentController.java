package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //分页查询
    @GetMapping
    public Result queryPage(StudentQueryParam param) {
        PageBean pageBean = studentService.queryPage(param);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryInfoById(@PathVariable Integer id) {
        Student student = studentService.queryInfoById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return Result.success();
    }

    @PutMapping("violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,
                            @PathVariable Integer score
    ) {

        studentService.violation(id, score);
        return Result.success();
    }
}
