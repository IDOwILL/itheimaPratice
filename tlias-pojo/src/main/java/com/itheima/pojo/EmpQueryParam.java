package com.itheima.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam extends PageParem{
    private String name;            //姓名
    private Integer gender;         //性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;        //入职开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;          //入职结束时间

}
