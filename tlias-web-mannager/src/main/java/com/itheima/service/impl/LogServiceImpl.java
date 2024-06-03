package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.EmpLog;
import com.itheima.pojo.OperationLog;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        logMapper.insert(empLog);
    }

    @Override
    public PageBean queryLog(PageParem param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        Page<OperationLog> page = logMapper.queryLog(param);
        return new PageBean(page.getTotal(),page.getResult());
    }
}
