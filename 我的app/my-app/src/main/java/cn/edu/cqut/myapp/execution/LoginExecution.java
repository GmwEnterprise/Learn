package cn.edu.cqut.myapp.execution;

import cn.edu.cqut.myapp.execution.enums.Login;
import lombok.Data;

@Data
public class LoginExecution {

  /**
   * 登陆验证结果
   */
  private Login result;

  /**
   * 登陆成功返回token
   */
  private String token;
}
