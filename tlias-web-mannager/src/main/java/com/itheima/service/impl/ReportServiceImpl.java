package com.itheima.service.impl;

import com.itheima.mapper.ReportMapper;
import com.itheima.pojo.Job;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
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
}
