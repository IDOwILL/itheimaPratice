package com.itheima.service;

import com.itheima.pojo.EmpExpr;

import java.util.List;

public interface EmpExprService {
    void deleteByIds(List<Integer> ids);

    void saveEmpExpr(List<EmpExpr> exprList);
}
