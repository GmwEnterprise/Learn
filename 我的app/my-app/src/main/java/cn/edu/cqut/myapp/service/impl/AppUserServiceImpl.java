package cn.edu.cqut.myapp.service.impl;

import cn.edu.cqut.myapp.dao.AppUserMapper;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.execution.LoginExecution;
import cn.edu.cqut.myapp.execution.enums.Login;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.util.TokenUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

  private final AppUserMapper userMapper;

  private final TokenUtils tokenUtils;

  @Override
  public AppUser getAppUserByPhone(String phone) {
    return userMapper.selectByUserPhone(phone);
  }

  @Override
  public boolean createAppUser(AppUser user) {
    int insertResult = userMapper.insertSelective(user);
    return insertResult > 0;
  }



  @Override
  public LoginExecution userLoginByPassword(String phone, String password, HttpServletRequest request) {
      AppUser target = getAppUserByPhone(phone);
      LoginExecution ex = new LoginExecution();
      if (target == null) {
        ex.setResult(Login.ERROR_USER_NOT_EXIST);
      } else if (!target.getPassword().equals(password)) {
        ex.setResult(Login.ERROR_PASSWORD_WRONG);
      } else {
        ex.setResult(Login.LOGIN_SUCCESS);
        ex.setToken(tokenUtils.getToken(target, request));
      }
      return ex;
    }

    @Override
    public String userLoginDirectly(AppUser user, HttpServletRequest request) {
      return tokenUtils.getToken(user, request);
  }

  @Override
  public AppUser getAppUserById(String userId) {
    return userMapper.selectByPrimaryKey(userId);
  }
}
