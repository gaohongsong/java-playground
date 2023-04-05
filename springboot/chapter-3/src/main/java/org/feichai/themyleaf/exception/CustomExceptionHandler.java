package org.feichai.themyleaf.exception;

import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.model.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.StringJoiner;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 处理基础异常
     * http://localhost:8080/api/myexcept
     */
    @ExceptionHandler(AppException.class)
    public Result HandleAppException(AppException ex) {
        Result<Object> result = new Result<>();
        result.setCode(ex.getCode());
        result.setMessage(ex.getMessage());

        return result;
    }

    /**
     * 处理鉴权异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Result HandleUnauthorizedException(UnauthorizedException ex) {
        Result<Object> result = new Result<>();
        result.setCode(ex.getCode());
        result.setMessage(ex.getMessage());

        return result;
    }

    /**
     * http://localhost:8080/hello
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result HandleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {

        Result<Object> result = new Result<>();
        result.setCode(400);
        result.setMessage(ex.getMessage());

        return result;
    }

    /**
     * 处理参数异常
     * {"message":"name: 名字不得超过8个字符;age: 年龄不得大于150","code":400,"data":null}
     curl -X POST --location "http://localhost:8080/addUser" \
         -H "Content-Type: application/json" \
         -d "{
               \"name\": \"asksdjladjfasdfas\",
               \"age\": 10222
             }"
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result HandleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Result<Object> result = new Result<>();

        StringJoiner sj = new StringJoiner(";");
        ex.getBindingResult().getFieldErrors().forEach(item -> sj.add(item.getField() + ": " + item.getDefaultMessage()));
        result.setCode(400);
        result.setMessage(sj.toString());

        return result;
    }

    /**
     * 处理其他异常
     * http://localhost:8080/api/except
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        log.error(ex.getMessage(), ex);

        Result<Object> result = new Result<>();
        result.setCode(500);
        result.setMessage("Internal Server Error");

        return result;
    }

}
