package cn.edu.cqut.permission.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class SpringMvcExceptionAdvice {

  @ExceptionHandler(PermissionException.class)
  public Object permissionExceptionHandler(HttpServletRequest request, PermissionException exp) {
    String url = request.getRequestURL().toString();
    log.error("unknown exception, url -> " + url, exp);
    JsonData fail = JsonData.fail(exp.getMessage());
    if (url.endsWith(".json")) {
      return fail;
    }
    return new ModelAndView("exception", fail.toMap());
  }

  @ExceptionHandler(Throwable.class)
  public Object throwableHandler(HttpServletRequest request, Throwable exp) {
    String url = request.getRequestURL().toString();
    log.error("unknown sys exception, url -> " + url, exp);
    JsonData fail = JsonData.fail("Unknown System Exception");
    if (url.endsWith(".json")) {
      return fail;
    }
    return new ModelAndView("exception", fail.toMap());
  }
}
