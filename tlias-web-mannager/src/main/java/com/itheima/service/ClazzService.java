package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface ClazzService {
    PageBean queryString(ClazzQueryParam clazzQueryParam);

    List<Clazz> queryList();
}
