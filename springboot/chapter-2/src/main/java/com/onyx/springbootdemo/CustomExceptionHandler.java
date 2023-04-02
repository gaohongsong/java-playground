package com.onyx.springbootdemo;

import com.onyx.springbootdemo.pojo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* 全局参数错误处理
*  `@ControllerAdvice`  是一个 Spring 中的注解，它提供了一种增强型的控制器（Controller）功能，可以用来处理全局异常、绑定数据等任务。
 使用  `@ControllerAdvice` 可以让开发者实现对于控制器的全局处理。在 Spring 中，它主要有以下几个使用场景：
 1. 统一异常处理：通过  `@ControllerAdvice`  注解，我们可以实现一个全局异常处理器。
    在现实开发中，开发者可以在处理异常时把异常信息包装成一个统一的响应格式。
 2. 数据绑定：使用  `@InitBinder`  可以预处理请求参数，从而使用校验注解进行参数校验。
    开发者可以使用 @ControllerAdvice 可以定义一个通用的 @InitBinder 方法，对所有的 Controller 中的请求参数进行预处理。
 3. 全局数据绑定：使用  `@ModelAttribute`  注解可以将数据绑定到 Model 中，可以在 JSP 或 Thymeleaf 中获取到它们。
    使用 @ControllerAdvice 可以在所有的 Controller 中定义一个通用的 @ModelAttribute 方法，
    从而可以在任何一个 Controller 中获取到 Model 中的数据。
 总的来说， `@ControllerAdvice`  可以对所有 Controller 生效，为开发者提供了一种统一处理 Controller 的方式，
 能够提高应用的健壮性和可维护性。
* */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request
    ) {
        ResponseVo respVo = new ResponseVo();
        respVo.setCode(500);

        // Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            Object fieldValue = fieldError.getRejectedValue();
            // errors.put(fieldName, errorMessage);

            // 遇到第一个错误就返回
            errorMessage = "[" + fieldName + "]" + errorMessage;
            respVo.setMessage(errorMessage);
            respVo.setData(fieldValue);
            break;
        }

        return new ResponseEntity<>(respVo, HttpStatus.OK);
    }
}


/*
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest
    ) {
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Current Timestamp", new Date());
        objectBody.put("Status", httpStatus.value());

        // Get all errors
        List<String> exceptionalErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        objectBody.put("Errors", exceptionalErrors);

        return new ResponseEntity<>(objectBody, httpStatus);
    }
}*/
