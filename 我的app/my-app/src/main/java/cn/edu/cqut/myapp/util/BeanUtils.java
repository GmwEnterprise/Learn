package cn.edu.cqut.myapp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {

  private static ApplicationContext context = null;

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    if (BeanUtils.context == null) {
      BeanUtils.context = context;
    }
  }

  public static <E> E getBean(Class<E> clazz) {
    return context.getBean(clazz);
  }

  public static Object getBean(String beanName) {
    return context.getBean(beanName);
  }
}
