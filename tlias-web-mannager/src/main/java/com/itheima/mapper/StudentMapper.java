package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    Page<Student> queryPage(StudentQueryParam param);

    void deleteByIds(List<Integer> ids);

    void saveStudent(Student student);

    Student queryInfoById(Integer id);

    void updateStudent(Student student);

    void violation(Integer id, Integer score);

    /**
     * 按clazz id查询学生人数
     *
     * @return 对象
     */
    Integer queryStudentCountByClazzId(int clazzId);

    @Select("select count(*) from student where clazz_id=#{id}")
    Integer counterById(Integer id);
}
