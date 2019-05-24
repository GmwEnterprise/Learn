package cn.edu.cqut.myapp.service.impl;

import cn.edu.cqut.myapp.common.ServiceReturnVal;
import cn.edu.cqut.myapp.dao.AppUserMapper;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.dto.AppUserBasicDto;
import cn.edu.cqut.myapp.enums.SexEnum;
import cn.edu.cqut.myapp.status.Login;
import cn.edu.cqut.myapp.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

  private final AppUserMapper appUserMapper;

  private AppUser dto2AppUser(AppUserBasicDto userBasic) {
    AppUser user = new AppUser();
    user.setUserId(userBasic.getUserId());
    user.setUsername(userBasic.getUsername());
    user.setPassword(userBasic.getPassword());
    Integer sex = userBasic.getSex();
    user.setSex(sex != null ? SexEnum.getSexEnum(sex) : null);
    user.setUserPhone(userBasic.getPhone());
    user.setUserEmail(userBasic.getEmail());
    return user;
  }

  @Override
  public AppUser createAppUser(AppUserBasicDto userBasic) {
    AppUser user = dto2AppUser(userBasic);
    int result = appUserMapper.insertSelective(user);
    return result > 0 ? appUserMapper.selectByPrimaryKey(user.getUserId()) : null;
  }

  @Override
  public AppUser updateAppUser(AppUserBasicDto userBasic) {
    AppUser user = dto2AppUser(userBasic);
    int result = appUserMapper.updateByPrimaryKeySelective(user);
    return result > 0 ? appUserMapper.selectByPrimaryKey(user.getUserId()) : null;
  }

  @Override
  public AppUser deleteAppUser(String userId) {
    AppUser user = appUserMapper.selectByPrimaryKey(userId);
    if (user != null) {
      appUserMapper.deleteByPrimaryKey(userId);
    }
    return user;
  }

  @Override
  public AppUser getUserByPhone(String phone) {
    return appUserMapper.selectByUserPhone(phone);
  }

  @Override
  public AppUser getUserById(String userId) {
    return appUserMapper.selectByPrimaryKey(userId);
  }

  @Override
  public ServiceReturnVal<Login, AppUser> userLoginOnBrowser(AppUserBasicDto userBasic) {
    ServiceReturnVal<Login, AppUser> returnVal = new ServiceReturnVal<>();
    AppUser user = appUserMapper.selectByUserPhone(userBasic.getPhone());
    if (user == null) {
      returnVal.setStatus(Login.ERROR_USER_NOT_EXIST);
    } else if (!user.getPassword().equals(userBasic.getPassword())) {
      returnVal.setStatus(Login.ERROR_PASSWORD_WRONG);
    } else {
      returnVal.setStatus(Login.LOGIN_SUCCESS);
      returnVal.setData(user);
    }
    return returnVal;
  }
}
