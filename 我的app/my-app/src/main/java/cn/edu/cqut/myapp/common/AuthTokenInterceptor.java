package cn.edu.cqut.myapp.common;

import cn.edu.cqut.myapp.util.BeanUtils;
import cn.edu.cqut.myapp.util.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthTokenInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (handler instanceof HandlerMethod) {
      // 如果AuthToken标注在控制器方法上，则校验token
      AuthToken authToken = ((HandlerMethod) handler).getMethodAnnotation(AuthToken.class);
      if (authToken != null) {
        // 需要校验token
        String token = request.getHeader("token");
        if (token == null || !BeanUtils.getBean(TokenUtils.class).checkToken(token, request)) {
          // 验证失败
          ObjectMapper objectMapper = BeanUtils.getBean(RedisConfig.class).getObjectMapper();
          String json = objectMapper.writeValueAsString(CommonErrorResponse.TOKEN_INVALID);
          response.setCharacterEncoding("UTF-8");
          response.setContentType("application/json;charset=UTF-8");
          response.getWriter().write(json);
          return false;
        }
      }
    }
    /*
     * 如果handler的类型是org.springframework.web.servlet.resource.ResourceHttpRequestHandler,
     * 则表示请求映射在了Controller类上，且类中没有匹配请求路径的防范
     */
    return true;
  }
}
