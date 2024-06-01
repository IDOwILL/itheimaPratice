package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpMapper {
    /*    @Select("SELECT t1.*,t2.`name` deptName FROM emp t1 LEFT JOIN dept  t2 ON t1.dept_id=t2.id LIMIT #{page},#{pageSize}")
        List<Emp> queryPage(Integer page,Integer pageSize);
        @Select("SELECT count(*) from emp")
        Long countTotal();*/
//    @Select("SELECT t1.*,t2.`name` deptName FROM emp t1 LEFT JOIN dept  t2 ON t1.dept_id=t2.id")
//    Page<Emp> queryPage(Integer page, Integer pageSize);

    Page<Emp> queryPage(EmpQueryParam param);

    @Insert("insert into tlias.emp (username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) VALUES " +
            "(#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveEmp(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp queryById(Integer id);


    /**
     * 更新员工信息
     *
     * @param emp emp
     */
    void updateEmp(Emp emp);
}
