package com.itheima.service;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption empPositionStatistic();

    List<Map> empGenderData();

    List<Map> studentDegreeData();


    Map<String, Object> getClazzAndStudentData();
}
