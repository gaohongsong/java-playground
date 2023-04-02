package org.feichai.themyleaf.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        // 日志过滤器，公共日志
        // 授权过滤器，全局鉴权
        log.info("LogFilter -> uri: {}", req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
