package com.onyx.springbootdemo.pojo;

import lombok.Data;

@Data
public class ResponseVo {
    private int code;
    private String message;
    private Object data;
}
