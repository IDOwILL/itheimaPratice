package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.pojo.StudentOption;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 员工职位统计
     *
     * @return jobOption
     */
    @GetMapping("/empJobData")
    public Result empPositionStatistic() {
        JobOption jobOption = reportService.empPositionStatistic();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData() {
        List<Map> mapList = reportService.empGenderData();
        return Result.success(mapList);
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData() {
        List<Map> mapList = reportService.studentDegreeData();
        return Result.success(mapList);
    }

    @GetMapping("/studentCountData")
    public Result studentCountData() {
        Map<String, Object> data=reportService.getClazzAndStudentData();
        return Result.success(data);
    }
}
