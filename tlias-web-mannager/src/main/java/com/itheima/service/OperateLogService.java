package com.itheima.service;

import com.itheima.pojo.OprerateLog;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;


public interface OperateLogService {
    PageBean queryLog(PageParem param);

    void inserLog(OprerateLog oprerateLog);
}
