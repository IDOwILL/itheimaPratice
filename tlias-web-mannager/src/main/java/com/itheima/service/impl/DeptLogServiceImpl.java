package com.itheima.service.impl;

import com.itheima.mapper.DeptLogMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptLogServiceImpl implements DeptLogService{
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Override
    public void insertLog(Dept dept) {
        String deptInfo = dept.toString();
        deptLogMapper.insertLog(deptInfo);
    }
}
