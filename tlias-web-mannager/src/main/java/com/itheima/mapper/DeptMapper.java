package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 深度映射器
 *
 * @author admin
 * @date 2024/05/28
 */
@Mapper
public interface DeptMapper {
    /**
     * 获取全部部门
     *
     * @return 列表＜dept＞
     */
    public List<Dept> getAll();

    /**
     * 按id删除部门
     */
    void deleteDeptById(Integer id);

    /**
     * 保存dept
     *
     * @param name 名称
     */
    void saveDept(String name);

    /**
     * 按id获取信息
     *
     * @param id 身份证件
     * @return 部
     */
    Dept getInfoById(Integer id);

    /**
     * 按id更新
     *
     * @param dept 部
     */
    void updateById(Dept dept);
}
