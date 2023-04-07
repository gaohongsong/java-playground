package com.feichai.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "t_authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authority;

    @ManyToMany(mappedBy = "my_authorities", cascade = CascadeType.ALL)
    private Set<MyUser> users = new HashSet<>();

    public Authority(String authority) {
        this.authority = authority;
    }
}
