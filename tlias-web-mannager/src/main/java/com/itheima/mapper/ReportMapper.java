package com.itheima.mapper;

import com.itheima.pojo.Job;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<Job> queryJob();

    //@MapKey("gender")如果直接是map集合的话，这个还是挺有用的
    List<Map> empGenderData();
}
