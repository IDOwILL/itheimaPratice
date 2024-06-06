package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface EmpService {
    PageBean queryPage(Integer page, Integer pageSize);

    PageBean queryPage(EmpQueryParam param);

    void saveEmp(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp queryById(Integer id);

    void updateEmp(Emp emp);

    List<Emp> queryList();

    LoginInfo login(Emp emp);
}
