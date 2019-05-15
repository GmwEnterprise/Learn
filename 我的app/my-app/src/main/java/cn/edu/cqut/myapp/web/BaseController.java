package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.vo.AjaxResponse;
import com.google.common.collect.Maps;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Map;

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

  default AjaxResponse fail(Object msgOrErrorData) {
    if (msgOrErrorData instanceof String) {
      return new AjaxResponse(false, ((String) msgOrErrorData), null);
    }
    return new AjaxResponse(false, DEFAULT_FAIL_MESSAGE, msgOrErrorData);
  }

  default AjaxResponse paramErrorOutput(List<ObjectError> errorList) {
    Map<String, String> errorMap = Maps.newHashMapWithExpectedSize(errorList.size());
    for (ObjectError objectError : errorList) {
      String key, value;
      if (objectError instanceof FieldError) {
        key = ((FieldError) objectError).getField();
      } else {
        key = objectError.getObjectName();
      }
      value = objectError.getDefaultMessage();
      errorMap.put(key, value);
    }
    return fail(errorMap);
  }
}
