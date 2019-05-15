package cn.edu.cqut.myapp.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginDto {

  @NotNull(message = "手机号不能为空")
  @Length(min = 8, max = 16, message = "手机号长度错误")
  private String phone;

  // 密码由前端加密为32位MD5码
  private String password;
}
