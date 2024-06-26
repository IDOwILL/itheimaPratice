package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.exception.BussinessException;
import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Student;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageBean queryString(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        log.info(clazzQueryParam.toString());
        Page<Clazz> clazzList = clazzMapper.queryString(clazzQueryParam);
        LocalDate now = LocalDate.now();
        clazzList.forEach(clazz -> {
            LocalDate endDate = clazz.getEndDate();
            LocalDate beginDate = clazz.getBeginDate();
            if (endDate != null && endDate.isBefore(now)) clazz.setStatus("已结课");//大于结束时间已结课
            if (endDate != null && endDate.isAfter(now) && beginDate != null && beginDate.isBefore(now))
                clazz.setStatus("已开班");//比结束早，比开始晚视为已开班
            if (endDate != null && endDate.isEqual(now) || beginDate != null && beginDate.isEqual(now))
                clazz.setStatus("已开班");//时间相等为已开班
            if (beginDate != null && beginDate.isAfter(now)) clazz.setStatus("未开班");//比开始时间早则未开班
        });
        return new PageBean(clazzList.getTotal(), clazzList.getResult());
    }

    @Override
    public List<Clazz> queryList() {
        return clazzMapper.queryList();
    }

    /**
     * 按id删除班级
     *
     * @param id 主键
     */
    @Transactional
    @Override
    public void deleteById(Integer id) {
        Integer num = studentMapper.counterById(id);
        if (num>=0) throw new BussinessException("部门还有人，别删");
        clazzMapper.deleteById(id);
    }

    @Override
    public Clazz queryInfoById(Integer id) {
        return clazzMapper.queryInfoById(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazzMapper.updateClazz(clazz);
    }

    @Override
    public void saveClazz(Clazz clazz) {
        clazzMapper.saveClazz(clazz);
    }
}
