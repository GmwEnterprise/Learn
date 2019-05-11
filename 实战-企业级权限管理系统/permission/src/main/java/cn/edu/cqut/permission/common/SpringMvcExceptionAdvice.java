package cn.edu.cqut.permission.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class SpringMvcExceptionAdvice {

  @ExceptionHandler({ PermissionException.class, ParamException.class })
  public Object customExceptionHandler(HttpServletRequest request, Exception e) {
    return getObject(request, e);
  }

  @ExceptionHandler({ Throwable.class })
  public Object otherExceptionHandler(HttpServletRequest request, Exception e) {
    return getObject(request, e);
  }

  private Object getObject(HttpServletRequest request, Exception e) {
    String url = request.getRequestURL().toString();
    if (url.endsWith(".page")) {
      log.error(String.format("unknown page exception. url: %s", url), e);
      return new ModelAndView("exception", JsonData.fail(e.getMessage()).toMap());
    }
    log.error(String.format("unknown ajax exception. url: %s", url), e);
    return JsonData.fail(e.getMessage());
  }
}
