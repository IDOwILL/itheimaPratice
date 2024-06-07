package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.OperateOperateLogMapper;
import com.itheima.pojo.OprerateLog;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.PageParem;
import com.itheima.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateOperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateOperateLogMapper operateOperateLogMapper;

    @Override
    public PageBean queryLog(PageParem param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        Page<OprerateLog> page=operateOperateLogMapper.queryPage(param);
        return new PageBean(page.getTotal(),page.getResult());
    }

    @Override
    public void inserLog(OprerateLog oprerateLog) {
        operateOperateLogMapper.insert(oprerateLog);
    }
}
