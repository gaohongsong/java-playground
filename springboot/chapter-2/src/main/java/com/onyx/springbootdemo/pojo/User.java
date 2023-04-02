package com.onyx.springbootdemo.pojo;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Length(max = 10, message = "用户名长度不能超过10个字符")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Column(nullable = false)
    private String password;

    @Max(value = 120, message = "年龄不大于120")
    @Min(value = 1, message = "年龄不小于1")
    @Column(nullable = false)
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age=age;
        this.password = "default";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
