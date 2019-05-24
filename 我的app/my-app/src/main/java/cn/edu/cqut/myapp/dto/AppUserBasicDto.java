package cn.edu.cqut.myapp.dto;

import lombok.Data;

/**
 * 用户基本信息
 */
@Data
public class AppUserBasicDto {

  private String userId;

  private String username;

  private String password;

  private Integer sex;

  private String phone;

  private String email;
}
