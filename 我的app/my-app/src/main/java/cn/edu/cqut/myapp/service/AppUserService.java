package cn.edu.cqut.myapp.service;

import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.vo.MapResult;

public interface AppUserService {

  AppUser getUserByPhone(String phone);

  boolean createUser(AppUser user);

  MapResult userLoginByPassword(AppUser user);
}
