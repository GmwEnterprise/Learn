package com.example.vuedemocrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("request url: {}, method: {}, from: {}:{}",
                request.getRequestURL(),
                request.getMethod(),
                request.getRemoteHost(),
                request.getRemotePort());
        return true;
    }
}
