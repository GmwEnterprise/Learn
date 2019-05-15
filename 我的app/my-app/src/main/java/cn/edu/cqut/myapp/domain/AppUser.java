package cn.edu.cqut.myapp.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppUser {

  private String userId;

  private String username;

  private String password;

  private String userPhoto;

  private String salt;

  private String userPhone;

  private String userEmail;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

  private String remark;
}