package com.feichai.security.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(Exception e) {
        log.error(e.toString());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");

        if (e instanceof BadCredentialsException) {
            mv.addObject("msg", "密码错误");
        } else {
            mv.addObject("msg", e.getMessage());
        }
        return mv;
    }
}
