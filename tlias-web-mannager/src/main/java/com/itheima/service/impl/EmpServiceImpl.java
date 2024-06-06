package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpExprService;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpExprService empExprService;
    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageBean queryPage(Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);
        Page<Emp> emps = null;
        //empMapper.queryPage((page - 1)*pageSize, pageSize);
        // Long total=empMapper.countTotal();
        return new PageBean(emps.getTotal(), emps.getResult());
    }

    @Override
    public PageBean queryPage(EmpQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        Page<Emp> emps = empMapper.queryPage(param);

        return new PageBean(emps.getTotal(), emps.getResult());
    }

    @Transactional
    @Override
    public void saveEmp(Emp emp) {

        try {

            empMapper.saveEmp(emp);
            Integer empId = emp.getId();
            System.out.println("emp.getId() = " + emp.getId());
            List<EmpExpr> exprList = emp.getExprList();
            log.info(exprList.toString());
            saveEmpExpr(exprList, empId);
        } finally {
            EmpLog empLog = new EmpLog();
            empLog.setOperateTime(LocalDateTime.now());
            empLog.setInfo("插入员工信息: " + emp);
            empLogService.insertLog(empLog);
        }
    }


    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public Emp queryById(Integer id) {
        Emp emp = empMapper.queryById(id);
        return emp;
    }

    @Transactional
    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
        Integer empId = emp.getId();
        empExprMapper.deleteByIds(Collections.singletonList(empId));
        List<EmpExpr> exprList = emp.getExprList();
        saveEmpExpr(exprList, empId);
    }

    @Override
    public List<Emp> queryList() {
        List<Emp> empList=empMapper.queryList();
        return empList;
    }

    @Override
    public LoginInfo login(Emp emp) {
        LoginInfo loginInfo=empMapper.login(emp);
        return loginInfo;
    }


    /**
     * 保存员工经历公用方法
     *
     * @param exprList expr列表
     * @param empId    emp_id
     */
    private void saveEmpExpr(List<EmpExpr> exprList, Integer empId) {
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(empId);
                System.out.println(empExpr.getEmpId());
                log.info(exprList.toString());
            });
            empExprMapper.saveEmpExpr(exprList);
        }
    }

}
