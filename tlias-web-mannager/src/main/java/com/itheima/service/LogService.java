package com.itheima.service;


import com.itheima.pojo.EmpLog;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;

import java.util.List;

public interface LogService {

    public void insertLog(EmpLog empLog);

    PageBean queryLog(PageParem param);
}
