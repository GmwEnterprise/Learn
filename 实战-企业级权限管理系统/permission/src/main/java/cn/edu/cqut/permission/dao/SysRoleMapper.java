package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysRole record);

  int insertSelective(SysRole record);

  SysRole selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysRole record);

  int updateByPrimaryKey(SysRole record);
}