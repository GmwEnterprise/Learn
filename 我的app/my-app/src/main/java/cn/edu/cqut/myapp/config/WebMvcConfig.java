package cn.edu.cqut.myapp.config;

import cn.edu.cqut.myapp.interceptor.HttpRequestMessageInterceptor;
import cn.edu.cqut.myapp.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HttpRequestMessageInterceptor())
        .addPathPatterns("/**");
    registry.addInterceptor(new TokenInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns(
            "/user/login",
            "/user/reg"
        );
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("post", "get");
  }
}
