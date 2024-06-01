package com.itheima.service.impl;

import com.itheima.mapper.EmpExprMapper;
import com.itheima.pojo.EmpExpr;
import com.itheima.service.EmpExprService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmpExprServiceImpl implements EmpExprService {
    @Autowired
    private EmpExprMapper empExprMapper;
    @Override
    public void deleteByIds(List<Integer> ids) {
        empExprMapper.deleteByIds(ids);
    }

    @Override
    public void saveEmpExpr(List<EmpExpr> exprList) {
        log.info(exprList.toString());
        empExprMapper.saveEmpExpr(exprList);
    }
}
