package cn.edu.cqut.myapp.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommonErrorResponse {

  /**
   * token校验失败
   */
  TOKEN_INVALID("身份验证失败！请登录！", 101),

  /**
   * 系统错误
   */
  SYSTEM_ERROR("系统错误！请稍后再试！", 102);

  private Boolean success;
  private String message;
  private Integer errorCode;

  CommonErrorResponse(String message, int errorCode) {
    this.success = false;
    this.message = message;
    this.errorCode = errorCode;
  }
}
