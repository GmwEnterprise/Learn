package cn.edu.cqut.myapp.service.impl;

import cn.edu.cqut.myapp.dao.AppUserMapper;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.enums.LoginExecution;
import cn.edu.cqut.myapp.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

  private final AppUserMapper userMapper;

  @Override
  public AppUser getUserByPhone(String phone) {
    return userMapper.selectByUserPhone(phone);
  }

  @Override
  public boolean createUser(AppUser user) {
    return userMapper.insertSelective(user) == 1;
  }

  @Override
  public LoginExecution userLoginByPassword(AppUser user) {
    AppUser appUser = getUserByPhone(user.getUserPhone());
    if (appUser == null) {
      return LoginExecution.ACCOUNT_NOT_EXIST;
    }
    if (!user.getPassword().equals(appUser.getPassword())) {
      return LoginExecution.WRONG_PASSWORD;
    }
    return LoginExecution.SUCCESS;
  }
}
