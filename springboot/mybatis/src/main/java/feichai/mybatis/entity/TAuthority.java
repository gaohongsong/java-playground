package feichai.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_authority
 * created by MybatisX-Generator
 */
@Data
public class TAuthority implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String authority;

    private static final long serialVersionUID = 1L;
}