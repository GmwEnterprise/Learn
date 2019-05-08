package cn.edu.cqut.permission.dao;

import cn.edu.cqut.permission.domain.SysLog;
import cn.edu.cqut.permission.domain.SysLogWithBLOBs;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysLogWithBLOBs record);

  int insertSelective(SysLogWithBLOBs record);

  SysLogWithBLOBs selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(SysLogWithBLOBs record);

  int updateByPrimaryKeyWithBLOBs(SysLogWithBLOBs record);

  int updateByPrimaryKey(SysLog record);
}