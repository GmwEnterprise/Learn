package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.vo.AjaxResponse;

public interface BaseController {

  String DEFAULT_SUCCESS_MESSAGE = "REQUEST SUCCESS";

  String DEFAULT_FAIL_MESSAGE = "REQUEST FAILED";

  default AjaxResponse success() {
    return new AjaxResponse(true, DEFAULT_SUCCESS_MESSAGE, null);
  }

  default AjaxResponse success(String message) {
    return new AjaxResponse(true, message, null);
  }

  default AjaxResponse success(String message, Object body) {
    return new AjaxResponse(true, message, body);
  }

  default AjaxResponse fail() {
    return new AjaxResponse(false, DEFAULT_FAIL_MESSAGE, null);
  }

  default AjaxResponse fail(String message) {
    return new AjaxResponse(false, message, null);
  }
}
