package com.example.fileupload.util;

import java.util.HashMap;

public class AjaxResponse extends HashMap<String, Object> {

  public AjaxResponse set(String key, Object value) {
    put(key, value);
    return this;
  }

  public static AjaxResponse success() {
    return new AjaxResponse().set("success", true);
  }

  public static AjaxResponse success(Object data) {
    return new AjaxResponse()
        .set("success", true)
        .set("data", data);
  }

  public static AjaxResponse fail(String message) {
    return new AjaxResponse()
        .set("success", true)
        .set("message", message);
  }
}
