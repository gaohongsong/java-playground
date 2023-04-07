package com.feichai.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class UserController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/loginPage")
    public String login() {
        return "login";
    }

    @GetMapping("/exception")
    public String error(HttpServletRequest request) {
        // 获取异常并抛出给全局处理器
        AuthenticationException ex = (AuthenticationException) WebUtils.getSessionAttribute(
                request,
                "SPRING_SECURITY_LAST_EXCEPTION"
        );

        if (ex != null) {
            throw ex;
        }

        return "redirect:/loginPage";
    }

    @ResponseBody
    @GetMapping("/role/admin")
    @Secured({"ROLE_admin"})
    public String admin() {
        return "模拟获取管理员数据";
    }

    @ResponseBody
    @GetMapping("/role/teacher")
    @Secured({"ROLE_teacher", "ROLE_admin"})
    public String teacher() {
        return "模拟获取教师数据";
    }

    @ResponseBody
    @GetMapping("/role/student")
    @Secured({"ROLE_student", "ROLE_admin"})
    public String student() {
        return "模拟获取学生数据";
    }

}
