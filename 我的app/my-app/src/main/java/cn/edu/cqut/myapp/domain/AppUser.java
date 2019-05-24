package cn.edu.cqut.myapp.domain;

import cn.edu.cqut.myapp.common.JsonLocalDateTime;
import cn.edu.cqut.myapp.enums.SexEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppUser {

  private String userId;

  private String username;

  private String password;

  private SexEnum sex;

  private String userPhoto;

  private String salt;

  private String userPhone;

  private String userEmail;

  @JsonLocalDateTime
  private LocalDateTime createTime;

  @JsonLocalDateTime
  private LocalDateTime updateTime;

  private String remark;
}
