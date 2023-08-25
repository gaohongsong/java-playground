package org.feichai.system.dao;

import org.feichai.common.config.MyMapper;
import org.feichai.system.domain.User;
import org.feichai.system.domain.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    List<User> findUserWithDept(User user);

    List<UserWithRole> findUserWithRole(Long userId);
}