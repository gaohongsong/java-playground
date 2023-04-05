package org.feichai.themyleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.exception.AppException;
import org.feichai.themyleaf.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ExceptionController {
    @GetMapping("/except")
    public Result testException() {
        int i = 1 / 0;

        Result<Integer> result = new Result<>();
        result.setCode(200);
        result.setData(i);
        result.setMessage("success");

        return result;
    }
    @GetMapping("/myexcept")
    public Result testMyException() {
        throw new AppException("Custom Exception", 400);
    }
}
