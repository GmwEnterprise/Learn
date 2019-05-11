package cn.edu.cqut.permission.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class ApplicationContextHelper implements ApplicationContextAware {

  private ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }

  public <T> T popBean(Class<T> clazz) {
    return context == null ? null : context.getBean(clazz);
  }

  public <T> T popBean(String name, Class<T> clazz) {
    return context == null ? null : context.getBean(name, clazz);
  }
}
