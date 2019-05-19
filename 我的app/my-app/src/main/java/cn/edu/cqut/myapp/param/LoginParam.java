package cn.edu.cqut.myapp.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginParam {

  @NotNull
  @Length(min = 8, max = 16, message = "手机号长度错误")
  private String phone;

  private String password;
}
