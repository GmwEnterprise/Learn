package cn.edu.cqut.myapp.common;

import lombok.Data;

/**
 * ResponseEntity
 */
@Data
public final class Re {

  private Boolean success;

  private String message;

  private Object data;

  private Re(Boolean success, String message, Object data) {}

  public static Re ok(Object data) {
    return new Re(true, "success", data);
  }

  public static Re fail(String message, Object data) {
    return new Re(false, message, data);
  }
}
