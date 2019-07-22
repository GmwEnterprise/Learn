package cn.gmwenterprise.website.cache;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component("jvm")
public class JvmMemoryCache implements Cache {
    private static final ConcurrentMap<String, Object> CACHE_REPOSITORY = new ConcurrentHashMap<>();

    @Override
    public void set(String key, Object value, long delay) {
        CACHE_REPOSITORY.put(key, value);
        new Thread(() -> {
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CACHE_REPOSITORY.remove(key);
        }).start();
    }

    @Override
    public void set(String key, Object value) {
        CACHE_REPOSITORY.put(key, value);
    }

    @Override
    public Object get(String key) {
        return CACHE_REPOSITORY.get(key);
    }

    @Override
    public boolean exist(String key) {
        return CACHE_REPOSITORY.containsKey(key);
    }
}
