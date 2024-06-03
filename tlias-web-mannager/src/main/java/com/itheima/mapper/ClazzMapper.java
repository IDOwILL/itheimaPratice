package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface ClazzMapper {
    Page<Clazz> queryString(ClazzQueryParam clazzQueryParam);

    List<Clazz> queryList();

    void saveClazz(Clazz clazz);

    @Delete("delete from clazz where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from clazz where id=#{id}")
    Clazz queryInfoById(Integer id);

    void updateClazz(Clazz clazz);
    @Select("select name from clazz;")
    List<String> queryAllClazzNames();
    @Select("SELECT id from clazz where name=#{clazzName}")
    int getClazzIdByName(String clazzName);
}
