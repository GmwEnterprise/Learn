package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.common.ResponseEntity;
import com.google.common.collect.Maps;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

public interface BaseController {

  String SUCCESS = "请求成功";

  default ResponseEntity success() {
    return new ResponseEntity(true, SUCCESS, null, null);
  }

  default ResponseEntity success(String message) {
    return new ResponseEntity(true, message, null, null);
  }

  default ResponseEntity success(Object body) {
    return new ResponseEntity(true, SUCCESS, body, null);
  }

  default ResponseEntity success(String message, Object body) {
    return new ResponseEntity(true, message, body, null);
  }

  default ResponseEntity fail(String message) {
    return new ResponseEntity(false, message, null, null);
  }

  default ResponseEntity fail(String message, Object errorMsg) {
    return new ResponseEntity(false, message, null, errorMsg);
  }

  default Map<String, String> errorMap(Errors errors) {
    HashMap<String, String> map = Maps.newHashMap();
    for (ObjectError error : errors.getAllErrors()) {
      String key;
      if (error instanceof FieldError) {
        // 字段错误
        key = ((FieldError) error).getField();
      } else {
        // 非字段错误
        key = error.getObjectName();
      }
      map.put(key, error.getDefaultMessage());
    }
    return map;
  }
}
