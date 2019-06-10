package com.example.vuedemocrud.mapper;

import com.example.vuedemocrud.po.People;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleMapper {
    /**
     * 查单项
     */
    @Select("select * from people where id = #{id}")
    People selectById(Integer id);

    /**
     * 查所有
     */
    @Select("select * from people")
    List<People> selectAll();

    /**
     * 新增
     */
    @Insert("insert into people (name, sex, role) values (#{name}, #{sex}, #{role})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(People people);

    /**
     * 删除
     */
    @Delete("delete from people where id = #{id}")
    int delete(Integer id);

    /**
     * 修改
     */
    @UpdateProvider(type = PeopleMapperProvider.class, method = "update")
    int update(People people);
}
