package feichai.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_my_user
 */
@Data
public class TMyUser implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 密码
     */
    private String password;

    /**
     * 
     */
    private String username;

    private static final long serialVersionUID = 1L;
}