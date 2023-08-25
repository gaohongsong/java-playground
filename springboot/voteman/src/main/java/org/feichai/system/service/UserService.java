package org.feichai.system.service;

import org.feichai.common.domain.QueryRequest;
import org.feichai.common.service.IService;
import org.feichai.system.domain.User;
import org.feichai.system.domain.UserWithRole;

import java.util.List;

public interface UserService extends IService<User> {
    User findByName(String userName);

    void updateLoginTime(String username);

    List<User> findUserWithDept(User user, QueryRequest request);

    void addUser(User user, Long[] roles);

    void deleteUsers(String ids);

    UserWithRole findById(Long userId);

    void updateUser(User user, Long[] roles);
}
