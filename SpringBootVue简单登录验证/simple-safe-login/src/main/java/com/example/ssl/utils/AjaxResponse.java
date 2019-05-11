package com.example.ssl.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResponse {

  private static final String DEFAULT_SUCCESS_MESSAGE = "REQUEST SUCCEED !";
  private static final String DEFAULT_FAILED_MESSAGE = "UNKNOWN ERROR !";

  private static final String FAIL_MESSAGE_TEMPLATE = "THIS REQUEST HAS FAILED: %s";

  private Boolean success;
  private String message;
  private Object body;

  public static AjaxResponse success(String message, Object body) {
    return new AjaxResponse(true, message, body);
  }

  public static AjaxResponse success(String message) {
    return new AjaxResponse(true, message, null);
  }

  public static AjaxResponse success() {
    return new AjaxResponse(true, DEFAULT_SUCCESS_MESSAGE, null);
  }

  public static AjaxResponse fail(String message) {
    return new AjaxResponse(false, String.format(FAIL_MESSAGE_TEMPLATE, message), null);
  }

  public static AjaxResponse fail() {
    return new AjaxResponse(false, String.format(FAIL_MESSAGE_TEMPLATE, DEFAULT_FAILED_MESSAGE), null);
  }
}
