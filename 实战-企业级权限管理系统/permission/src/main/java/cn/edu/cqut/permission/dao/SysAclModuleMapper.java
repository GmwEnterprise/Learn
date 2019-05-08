package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysAclModule;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAclModuleMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysAclModule record);

  int insertSelective(SysAclModule record);

  SysAclModule selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysAclModule record);

  int updateByPrimaryKey(SysAclModule record);
}