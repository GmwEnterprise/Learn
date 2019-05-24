package cn.edu.cqut.myapp.vo;

import cn.edu.cqut.myapp.domain.AppUser;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppUserVo {

  private String userId;

  private String username;

  private String userPhoto;

  private String userPhone;

  private String userEmail;

  private LocalDateTime createTime;

  private String remark;

  public AppUserVo(AppUser user) {
    setUserId(user.getUserId());
    setUsername(user.getUsername());
    setUserPhoto(user.getUserPhoto());
    setUserPhone(user.getUserPhone());
    setUserEmail(user.getUserEmail());
    setCreateTime(user.getCreateTime());
    setRemark(user.getRemark());
  }
}
