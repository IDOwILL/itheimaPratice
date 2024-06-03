package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    Page<Student> queryPage(StudentQueryParam param);

    void deleteByIds(List<Integer> ids);

    void saveStudent(Student student);

    Student queryInfoById(Integer id);

    void updateStudent(Student student);

    @Update("update student set violation_count=violation_count+1,violation_score=#{score} where id=#{id}")
    void violation(Integer id, Integer score);

    /**
     * 按clazz id查询学生人数
     *
     * @return 对象
     */
    Integer queryStudentCountByClazzId(int clazzId);
}
