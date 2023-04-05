package org.feichai.themyleaf.exception;

import lombok.Data;

import java.io.Serial;

@Data
public class AppException extends RuntimeException {
    /**
     * `serialVersionUID` 是Java中一个特殊的静态变量，用于序列化和反序列化Java对象时，用于保证版本的兼容性。
     * 在Java序列化时，每个序列化的类都会有一个版本号，即serialVersionUID ，序列化后的字节流中存储被序列化对象的类相关信
     * 息（包括类名、对象属性等），反序列化时需要根据serialVersionUID来确认被反序列化的类与序列化时的类是否一致，从而保证反序列化的正确性。
     * 如果在反序列化时，检测到被反序列化的类的serialVersionUID与序列化时不一致，就会抛出 `InvalidClassException` 异常，导致反序列化失败。
     * 因此，在定义序列化的类时，显式地定义一个serialVersionUID是很有必要的，它可以确保在类发生变化时，能够保持版本的兼容性，避免出现反序列化失败的情况。
     */
    @Serial
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;

    public AppException(String message) {
        super(message);
        this.message = message;
    }

    public AppException(String message, int code) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
