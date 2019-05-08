package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysRoleUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleUserMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysRoleUser record);

  int insertSelective(SysRoleUser record);

  SysRoleUser selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysRoleUser record);

  int updateByPrimaryKey(SysRoleUser record);
}