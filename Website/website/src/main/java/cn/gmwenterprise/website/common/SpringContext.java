package cn.gmwenterprise.website.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringContext implements ApplicationContextAware {
    private ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            context = applicationContext;
        }
    }

    public ApplicationContext getContext() {
        return context;
    }

    public <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public Object getBean(String className) {
        return context.getBean(className);
    }
}
