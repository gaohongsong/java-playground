package com.onyx.springbootdemo;

import com.onyx.springbootdemo.pojo.ResponseVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidateCommonHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request
    ) {
        ResponseVo respVo = new ResponseVo();
        respVo.setCode(500);

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String defaultMessage = fieldError.getDefaultMessage();
            respVo.setMessage(defaultMessage);
            Object value =fieldError.getRejectedValue();
            respVo.setData(value);
            break;
        }

        return new ResponseEntity<>(respVo, HttpStatus.OK);
    }
}
