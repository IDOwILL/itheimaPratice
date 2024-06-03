package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.EmpLog;
import com.itheima.pojo.OperationLog;
import com.itheima.pojo.PageParem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(EmpLog empLog);

    @Select("select id, operate_time, info methodParams from emp_log ")
    Page<OperationLog> queryLog(PageParem param);
}
