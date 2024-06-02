package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageBean;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Slf4j
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageBean queryString(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        log.info(clazzQueryParam.toString());
        Page<Clazz> clazzList=clazzMapper.queryString(clazzQueryParam);
        return new PageBean(clazzList.getTotal(),clazzList.getResult());
    }

    @Override
    public List<Clazz> queryList() {
        List<Clazz> clazzList=clazzMapper.queryList();
        return clazzList;
    }
}
