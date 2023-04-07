package feichai.mybatis.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MyUser {
    private Integer id;

    private String username;

    private String password;

    private Set<Authority> authorities = new HashSet<>();

    public MyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
