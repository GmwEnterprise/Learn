package cn.edu.cqut.myapp.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class HttpRequestMessageInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String url = request.getRequestURL().toString();
    String remoteAddr = request.getRemoteAddr();
    request.setAttribute("start", System.currentTimeMillis());
    log.info("request url: {}, from addr: {}", url, remoteAddr);
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    Long start = (Long) request.getAttribute("start");
    long costs = System.currentTimeMillis() - start;
    String remoteAddr = request.getRemoteAddr();
    log.info("the req from addr[{}] costs {} ms.", remoteAddr, costs);
  }
}
