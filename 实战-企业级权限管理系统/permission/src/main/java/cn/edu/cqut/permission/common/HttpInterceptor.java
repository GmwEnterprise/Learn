package cn.edu.cqut.permission.common;

import cn.edu.cqut.permission.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String url = request.getRequestURL().toString();
    Map<String, String[]> paramMap = request.getParameterMap();
    log.info("request start. url: {}, params: {}", url, JsonMapper.obj2String(paramMap));
    long start = System.currentTimeMillis();
    request.setAttribute("start", start);
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    String url = request.getRequestURL().toString();
    Map<String, String[]> paramMap = request.getParameterMap();
    Long start = (Long) request.getAttribute("start");
    Long end = System.currentTimeMillis();
    log.info("request finished. url: {}, cost: {}ms", url, end - start);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    String url = request.getRequestURL().toString();
    Map<String, String[]> paramMap = request.getParameterMap();
    log.info("request complete. url: {}, params: {}", url, JsonMapper.obj2String(paramMap));
  }
}
