package cn.edu.cqut.myapp.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class AppUserUpdate {

  @NotNull(message = "请提供要修改的用户ID")
  private String userId;

  @Length(min = 1, max = 16, message = "用户名长度错误")
  private String username;

  @Length(min = 8, max = 16, message = "手机号长度错误")
  private String userPhone;

  @Length(min = 8, max = 128, message = "邮箱长度错误")
  private String userEmail;
}
