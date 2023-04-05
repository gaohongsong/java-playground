package org.feichai.themyleaf.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.utils.MiscUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Component
public class LogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        // 日志过滤器，公共日志
        String requestURI = req.getRequestURI();
        log.info("LogFilter -> uri: {}", requestURI);
        for (Map.Entry<String, String[]> entry : servletRequest.getParameterMap().entrySet()) {
            log.info("LogFilter -> param: " + entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }

        // 登录/授权过滤器
        // http://localhost:8080/403/hello?name=pitou&age=18&continue
        if (MiscUtils.loginCheckFailed(new String[]{
                "/403/hello",
                "/admin/**"
        }, requestURI)) {
            String errMsg = "403: Login Required!";
            log.error(errMsg);
            servletResponse.getWriter().write(errMsg);
            return;
        }

        // 放行，继续后面的业务处理
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
