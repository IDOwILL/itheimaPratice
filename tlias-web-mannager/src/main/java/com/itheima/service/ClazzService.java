package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface ClazzService {
    //新增班级
    void saveClazz(Clazz clazz);

    PageBean queryString(ClazzQueryParam clazzQueryParam);

    List<Clazz> queryList();

    void deleteById(Integer id);

    Clazz queryInfoById(Integer id);

    void updateClazz(Clazz clazz);
}
