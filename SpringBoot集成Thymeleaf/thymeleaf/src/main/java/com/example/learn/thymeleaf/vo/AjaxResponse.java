package com.example.learn.thymeleaf.vo;

public class AjaxResponse {

  private boolean success;
  private String message;
  private Object body;

  public static AjaxResponse success(Object body) {
    return new AjaxResponse(true, "success", body);
  }

  public static AjaxResponse fail(String message) {
    return new AjaxResponse(true, message, null);
  }

  public AjaxResponse() {
  }

  private AjaxResponse(boolean success, String message, Object body) {
    this.success = success;
    this.message = message;
    this.body = body;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }
}
