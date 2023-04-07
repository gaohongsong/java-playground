package feichai.mybatis.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Authority {
    private Integer id;
    private String authority;

    private Set<MyUser> users = new HashSet<>();

    public Authority(String authority) {
        this.authority = authority;
    }
}
