package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
@Component
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 获取全部
     * @return 列表＜dept＞
     *
     */
    @Override
    public List<Dept> getAll() {

        return deptMapper.getAll();
    }

    /**
     * 按id删除部门
     *
     * @param id 部门主键
     */
    @Override
    public void deleteDeptById(Integer id) {
        deptMapper.deleteDeptById(id);
    }

    @Override
    public void saveDept(Dept dept) {
        String name = dept.getName();
        deptMapper.saveDept(name);
    }

    /**
     * 按id获取信息
     *
     * @param id 主键
     * @return 部门
     */
    @Override
    public Dept getInfoById(Integer id) {
       Dept dept= deptMapper.getInfoById(id);
        return dept;
    }

    @Override
    public void updateById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}
