package com.feichai.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_persistent_login")
public class PersistentLogin {
    @Id
    private String series;
    private String username;
    private String token;
    private Date last_used;
}
