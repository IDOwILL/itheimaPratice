package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageBean queryPage(StudentQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        Page<Student> studentPage = studentMapper.queryPage(param);
        return new PageBean(studentPage.getTotal(),studentPage.getResult());
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void saveStudent(Student student) {
        studentMapper.saveStudent(student);
    }

    @Override
    public Student queryInfoById(Integer id) {
        Student student=studentMapper.queryInfoById(id);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.violation(id, score);
    }
}
