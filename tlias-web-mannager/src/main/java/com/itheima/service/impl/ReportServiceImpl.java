package com.itheima.service.impl;

import com.itheima.mapper.ReportMapper;
import com.itheima.pojo.Job;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentOption;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public JobOption empPositionStatistic() {
        List<Job> jobList = reportMapper.queryJob();
        List<String> jobToList = jobList.stream().map(job -> job.getJob()).toList();
        List<String> num = jobList.stream().map(job -> job.getNum()).toList();
        return new JobOption(jobToList, num);
    }

    @Override
    public List<Map> empGenderData() {

        return  reportMapper.empGenderData();
    }

    @Override
    public List<Map> studentDegreeData() {
        List<Map> mapList = reportMapper.studentDegreeData();
        return mapList;
    }

    @Override
    public StudentOption studentCountData() {
        List<Map> mapList = reportMapper.studentCountData();
        List<Object> clazzList = mapList.stream().map(map -> map.get("clazzName")).toList(); // Ensure map key is "clazzName"
        List<Object> dataList = mapList.stream().map(map -> map.get("dataValue")).toList(); // Ensure map key is "dataValue"
        log.info(mapList.toString());
        return new StudentOption(clazzList, dataList);
    }
}
