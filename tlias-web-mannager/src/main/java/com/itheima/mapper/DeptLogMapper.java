package com.itheima.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log (create_time,description) values(now(),#{deptInfo})")
    void insertLog(String deptInfo);
}
