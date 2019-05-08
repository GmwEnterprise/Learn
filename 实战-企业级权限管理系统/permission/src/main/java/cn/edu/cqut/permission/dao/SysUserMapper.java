package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysUser record);

  int insertSelective(SysUser record);

  SysUser selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysUser record);

  int updateByPrimaryKey(SysUser record);
}