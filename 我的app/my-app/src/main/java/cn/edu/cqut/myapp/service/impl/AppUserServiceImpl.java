package cn.edu.cqut.myapp.service.impl;

import cn.edu.cqut.myapp.dao.AppUserMapper;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.vo.MapResult;
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
  public MapResult userLoginByPassword(AppUser user) {
    return null;
  }
}
