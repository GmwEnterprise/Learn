package cn.edu.cqut.myapp.dao;

import cn.edu.cqut.myapp.domain.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper {

  AppUser selectByPrimaryKey(String userId);

  AppUser selectByUserPhone(String phone);

  int insert(AppUser record);

  int insertSelective(AppUser record);

  int updateByPrimaryKeySelective(AppUser record);

  int updateByPrimaryKey(AppUser record);

  int deleteByPrimaryKey(String userId);
}