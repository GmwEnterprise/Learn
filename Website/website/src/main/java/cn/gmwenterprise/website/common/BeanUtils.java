package cn.gmwenterprise.website.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
@Component
public class BeanUtils implements ApplicationContextAware {
    private static final String BEAN_INIT_STATUS_OUTPUT = "bean init status [{}]: '{}'";
    private ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            context = applicationContext;
        }
        DataSource bean = context.getBean(DataSource.class);
        log.info(BEAN_INIT_STATUS_OUTPUT, "DataSource", bean);
        log.info(BEAN_INIT_STATUS_OUTPUT, "     Redis", context.getBean("redisTemplate"));
    }

    public <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    public Object getBean(String className) {
        return context.getBean(className);
    }
}
