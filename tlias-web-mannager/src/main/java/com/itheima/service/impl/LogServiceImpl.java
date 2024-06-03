package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.pojo.OperationLog;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private EmpLogMapper empLogMapper;

    @Override
    public PageBean queryLog(PageParem param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        Page<OperationLog> page = empLogMapper.queryLog(param);
        return new PageBean(page.getTotal(),page.getResult());
    }
}
