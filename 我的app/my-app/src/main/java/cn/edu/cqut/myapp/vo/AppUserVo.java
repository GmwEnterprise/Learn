package cn.edu.cqut.myapp.vo;

import cn.edu.cqut.myapp.domain.AppUser;

public class AppUserVo extends AppUser {

  public AppUserVo(AppUser user) {
    setUserId(user.getUserId());
    setUsername(user.getUsername());
    setPassword(null);
    setUserPhone(user.getUserPhone());
    setUserPhoto(user.getUserPhoto());
    setUserEmail(user.getUserEmail());
    setSalt(null);
    setCreateTime(user.getCreateTime());
    setUpdateTime(null);
    setRemark(user.getRemark());
  }
}
