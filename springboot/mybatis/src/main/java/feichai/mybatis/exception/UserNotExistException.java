package feichai.mybatis.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserNotExistException extends AppException {
    static final long serialVersionUID = -12L;

    public UserNotExistException(String message) {
        super(message);
    }
}
