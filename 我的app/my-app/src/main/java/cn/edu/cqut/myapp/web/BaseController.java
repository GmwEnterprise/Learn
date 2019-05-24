package cn.edu.cqut.myapp.web;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseController {

  /**
   * 获取当前线程的请求实例
   */
  default HttpServletRequest request() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }

  /**
   * 获取当前线程的响应实例
   */
  default HttpServletResponse response() {
    return ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
  }
}
