package com.feichai.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "t_my_user")
// @Table(name = "t_my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", length = 64, nullable = false)
    private String username;

    @Column(columnDefinition = "VARCHAR(128) DEFAULT NULL COMMENT '密码'")
    private String password;

    // https://juejin.cn/post/6963550783132893198
    @ManyToMany(targetEntity = Authority.class, cascade = CascadeType.ALL)
    @JoinTable(name = "my_user_authority",
            joinColumns = @JoinColumn(name = "ref_my_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ref_authority_id", referencedColumnName = "id")
    )
    private Set<Authority> my_authorities = new HashSet<>();
}
