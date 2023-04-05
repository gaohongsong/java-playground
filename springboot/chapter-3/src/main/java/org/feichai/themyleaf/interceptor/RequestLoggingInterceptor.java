package org.feichai.themyleaf.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.utils.MiscUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

// @Slf4j
@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // before Controller.func
        LOGGER.info("preHandle -> uri: {} -> {}", request.getRequestURI(), handler);
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            sb.append(entry.getKey()).append("=").append(Arrays.toString(entry.getValue())).append(",");
        }
        LOGGER.info("preHandle -> params: {} -> {}", sb, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // after Controller.func and before mv
        LOGGER.info("postHandle -> uri: {} -> {}", request.getRequestURI(), handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) throws Exception {
        // after mv（视图渲染）
        LOGGER.info("afterCompletion -> uri: {} -> {}", request.getRequestURI(), handler);
    }
}