package com.example.learn.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserMessageStorage {

    private static Map<String, Authentication> map = new ConcurrentHashMap<>();

    public void set(String key, Authentication value) {
        map.put(key, value);
    }

    public Authentication get(String key) {
        return map.get(key);
    }
}
