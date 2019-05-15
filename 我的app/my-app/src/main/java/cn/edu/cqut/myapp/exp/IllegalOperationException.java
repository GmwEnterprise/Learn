package cn.edu.cqut.myapp.exp;

/**
 * 非法操作
 */
public class IllegalOperationException extends RuntimeException {

  public IllegalOperationException() {
  }

  public IllegalOperationException(String message) {
    super(message);
  }

  public IllegalOperationException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalOperationException(Throwable cause) {
    super(cause);
  }

  public IllegalOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
