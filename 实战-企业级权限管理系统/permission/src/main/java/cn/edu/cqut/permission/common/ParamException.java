package cn.edu.cqut.permission.common;

public class ParamException extends RuntimeException {

  public ParamException() {
  }

  public ParamException(String message) {
    super(message);
  }

  public ParamException(String message, Throwable cause) {
    super(message, cause);
  }

  public ParamException(Throwable cause) {
    super(cause);
  }

  public ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
