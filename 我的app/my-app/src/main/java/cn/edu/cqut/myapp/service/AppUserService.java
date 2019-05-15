package cn.edu.cqut.myapp.service;

import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.enums.LoginExecution;

public interface AppUserService {

  AppUser getUserByPhone(String phone);

  boolean createUser(AppUser user);

  LoginExecution userLoginByPassword(AppUser user);
}
