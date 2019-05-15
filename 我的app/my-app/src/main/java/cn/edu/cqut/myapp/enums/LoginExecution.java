package cn.edu.cqut.myapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginExecution {
  /**
   * 账户不存在
   */
  ACCOUNT_NOT_EXIST("账户不存在"),

  /**
   * 密码错误
   */
  WRONG_PASSWORD("密码错误"),

  /**
   * 非法登陆
   */
  ILLEGAL_LOGIN("非法登陆"),

  /**
   * 验证成功
   */
  SUCCESS("验证成功");

  private String message;
}
