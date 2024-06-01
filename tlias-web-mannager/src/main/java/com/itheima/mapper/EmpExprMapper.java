package com.itheima.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {


    void saveEmpExpr(List empList);

    void deleteByIds(List<Integer> ids);
}
