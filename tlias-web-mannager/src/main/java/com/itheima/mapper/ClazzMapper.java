package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    Page<Clazz> queryString(ClazzQueryParam clazzQueryParam);

    List<Clazz> queryList();
}
