package feichai.mybatis.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppException extends RuntimeException {
    static final long serialVersionUID = -1L;

    private String message;

    public AppException(String message) {
        super(message);
        this.message = message;
    }
}

