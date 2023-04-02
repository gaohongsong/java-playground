package org.feichai.themyleaf.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        log.info("EncodingFilter -> uri: {}", req.getRequestURI());

        // 预处理场景，比如设置编码编码
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setHeader("X-Api-Version", "1.0");

        filterChain.doFilter(servletRequest, servletResponse);

        // 后处理场景
        log.info("EncodingFilter -> uri: {}, clean after response", req.getRequestURI());

    }
}
