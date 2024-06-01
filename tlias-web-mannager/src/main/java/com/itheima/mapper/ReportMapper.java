package com.itheima.mapper;

import com.itheima.pojo.Job;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<Job> queryJob();

    //@MapKey("gender")
    List<Map> empGenderData();
}
