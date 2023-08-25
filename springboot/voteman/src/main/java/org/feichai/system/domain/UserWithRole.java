package org.feichai.system.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithRole extends User {
    private static final long serialVersionUID = -234235234234234L;

    private Long roleId;
    private List<Long> roleIds;
}
