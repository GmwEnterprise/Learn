package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysDept;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDeptMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysDept record);

  int insertSelective(SysDept record);

  SysDept selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysDept record);

  int updateByPrimaryKey(SysDept record);
}