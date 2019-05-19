package cn.edu.cqut.myapp.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class Register {

  @NotNull
  @Length(min = 8, max = 16, message = "手机号长度错误")
  private String phone;

  @NotNull
  @Length(min = 1, max = 16, message = "用户名长度错误")
  private String username;

  private String password;
}
