package org.feichai.themyleaf.config;

import org.feichai.themyleaf.interceptor.LoginRequiredInterceptor;
import org.feichai.themyleaf.interceptor.RequestLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RequestLoggingInterceptor requestLoggingInterceptor;
    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    /**
     * http://localhost:8080/hello?name=pitou&age=18&continue
     * 倒序执行拦截器的postHandle和afterCompletion方法
     * 19:55:56 INFO  o.f.t.i.RequestLoggingInterceptor - preHandle -> uri: /hello
     * 19:55:56 INFO  o.f.t.i.LoginRequiredInterceptor - preHandle -> uri: /hello

     * 19:55:56 ERROR o.f.t.controller.HelloController - hello handle request with name=pitou and age=18

     * 19:55:56 INFO  o.f.t.i.LoginRequiredInterceptor - postHandle -> uri: /hello
     * 19:55:56 INFO  o.f.t.i.RequestLoggingInterceptor - postHandle -> uri: /hello

     * 19:55:56 INFO  o.f.t.i.LoginRequiredInterceptor - afterCompletion -> uri: /hello
     * 19:55:56 INFO  o.f.t.i.RequestLoggingInterceptor - afterCompletion -> uri: /hello
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器
        registry.addInterceptor(requestLoggingInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.js",
                        "/**/*.css"
                        );

        registry.addInterceptor(loginRequiredInterceptor)
                .addPathPatterns("/**");
    }
}
