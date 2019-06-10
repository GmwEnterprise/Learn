package com.example.vuedemocrud.mapper;

import com.example.vuedemocrud.po.People;
import org.apache.ibatis.jdbc.SQL;

public class PeopleMapperProvider {
    /**
     * 选择更新sql
     * @param people 参数
     * @return sql语句
     */
    public String update(People people) {
        return new SQL() {{
            UPDATE("people");
            if (people.getName() != null && !"".equals(people.getName())) {
                SET("name = #{name}");
            }
            if (people.getSex() != null) {
                SET("sex = #{sex}");
            }
            if (people.getRole() != null && !"".equals(people.getRole())) {
                SET("role = #{role}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
}
