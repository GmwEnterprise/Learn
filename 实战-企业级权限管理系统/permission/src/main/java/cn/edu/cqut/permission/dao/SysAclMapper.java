package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysAcl;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAclMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysAcl record);

  int insertSelective(SysAcl record);

  SysAcl selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysAcl record);

  int updateByPrimaryKey(SysAcl record);
}