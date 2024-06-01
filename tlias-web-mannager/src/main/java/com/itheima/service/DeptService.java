package com.itheima.service;

import com.itheima.pojo.Dept;

import java.io.IOException;
import java.util.List;

public interface DeptService {
    /**
     * 获取全部部门
     *
     * @return 列表＜dept＞
     * @throws IOException IOException
     */
    public List<Dept> getAll() throws IOException;

    /**
     * 按id删除部门
     *
     * @param id 部门主键
     */
    void deleteDeptById(Integer id);

    void saveDept(Dept dept);

    Dept getInfoById(Integer id);

    void updateById(Dept dept);
}
