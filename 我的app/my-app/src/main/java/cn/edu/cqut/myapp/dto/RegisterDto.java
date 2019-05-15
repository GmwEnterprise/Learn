package cn.edu.cqut.myapp.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class RegisterDto {

  @NotNull(message = "手机号不能为空")
  @Length(min = 8, max = 16, message = "手机号长度错误")
  private String phone;

  @NotNull(message = "密码不能为空")
  @Length(min = 8, max = 20)
  private String password;

  @NotNull(message = "请设置用户名")
  @Length(min = 1, max = 16, message = "用户名长度应在16个字符以内")
  private String username;
}
