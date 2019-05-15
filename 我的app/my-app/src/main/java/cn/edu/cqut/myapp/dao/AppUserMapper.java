package cn.edu.cqut.myapp.dao;

import cn.edu.cqut.myapp.domain.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper {

  int deleteByPrimaryKey(String userId);

  int insert(AppUser record);

  int insertSelective(AppUser record);

  AppUser selectByPrimaryKey(String userId);

  int updateByPrimaryKeySelective(AppUser record);

  int updateByPrimaryKey(AppUser record);

  AppUser selectByUserPhone(String phone);
}