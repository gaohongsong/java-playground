package org.feichai.themyleaf.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.feichai.themyleaf.utils.MiscUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// @Slf4j
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRequiredInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // before Controller.func
        String requestURI = request.getRequestURI();
        LOGGER.info("preHandle -> uri: {} -> {}", requestURI, handler);

        // 登录/授权过滤器
        // http://localhost:8080/api/hello?name=pitou&age=18&continue
        if (MiscUtils.loginCheckFailed(new String[]{
                "/api/hello",
                "/admin/**"
        }, requestURI)) {
            String errMsg = "403: Login Required!";
            LOGGER.error(errMsg);
            // 返回false，将不会执行目标方法，直接返回200，或者我们定义response
            // response.getWriter().write(errMsg);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView
    ) throws Exception {
        // after Controller.func and before mv
        LOGGER.info("postHandle -> uri: {} -> {}", request.getRequestURI(), handler);
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception exception
    ) throws Exception {
        // after mv（视图渲染）
        LOGGER.info("afterCompletion -> uri: {} -> {}", request.getRequestURI(), handler);
    }
}