package com.itheima.service;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageBean queryPage(StudentQueryParam param);

    void deleteByIds(List<Integer> ids);

    void saveStudent(Student student);

    Student queryInfoById(Integer id);

    void updateStudent(Student student);

    void violation(Integer id, Integer score);
}
