package org.feichai.themyleaf.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Result<T> {
    private String message;
    private int code;
    private T data;
}
