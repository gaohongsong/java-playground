package org.feichai.themyleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    /**
     * @param name 姓名
     * @param age 年龄
     * @return 提示字符

     * 过滤器基于函数回调，在Servlet之前拦截请求，对所有请求均起作用（比如静态资源）
     * 18:44:51 INFO  o.feichai.themyleaf.filter.LogFilter - LogFilter -> uri: /hello
     * 18:44:51 INFO  o.feichai.themyleaf.filter.LogFilter - LogFilter -> param: name = [pitou]
     * 18:44:51 INFO  o.feichai.themyleaf.filter.LogFilter - LogFilter -> param: age = [18]

     * 18:44:51 DEBUG o.s.web.servlet.DispatcherServlet - GET "/hello?name=pitou&age=18", parameters={masked}
     * 18:44:51 DEBUG o.s.w.s.m.m.a.RequestMappingHandlerMapping - Mapped to org.feichai.themyleaf.controller.HelloController#hello(String, Integer)

     * 拦截器基于Java反射机制，在请求处理（Controller#func）前拦截请求，进针对Controller请求起作用
     * 拦截器，可以访问请求上下文，获取Bean，注入Service，并且可以精细控制拦截目标路径（addPathPatterns）
     * 18:44:51 INFO  o.f.t.i.RequestLoggingInterceptor - preHandle -> uri: /hello
     * 18:44:51 INFO  o.f.t.i.RequestLoggingInterceptor - preHandle -> params: name=[pitou],age=[18],

     * 请求处理环节
     * 18:44:51 ERROR o.f.t.controller.HelloController - hello handle request with name=pitou and age=18
     * 18:44:51 DEBUG o.s.w.s.m.m.a.RequestResponseBodyMethodProcessor - Using 'text/html'....
     * 18:44:51 DEBUG o.s.w.s.m.m.a.RequestResponseBodyMethodProcessor - Writing ["Hello pitou!"]

     * 18:44:51 INFO  o.f.t.i.RequestLoggingInterceptor - postHandle -> uri: /hello
     * 18:44:51 INFO  o.f.t.i.RequestLoggingInterceptor - afterCompletion -> uri: /hello

     * 18:44:51 DEBUG o.s.web.servlet.DispatcherServlet - Completed 200 OK
     */
    @GetMapping({"/hello", "/403/hello", "/api/hello"})
    public String hello(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        log.error("hello handle request with name={} and age={}", name, age);
        return "Hello " + (name != null ? name : "World") + "!";
    }

}
