package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.OprerateLog;
import com.itheima.pojo.PageParem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OperateOperateLogMapper {
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId},#{operateTime},#{className},#{methodName},#{methodParams},#{returnValue},#{costTime})")
    void insert(OprerateLog oprerateLog);
    @Select("select *,emp.name operateEmpName from operate_log left join emp on operate_emp_id=emp.id")
    Page<OprerateLog> queryPage(PageParem param);
}
