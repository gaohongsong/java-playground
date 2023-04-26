package org.feichai.system.service;

import org.feichai.common.service.IService;
import org.feichai.system.domain.User;

public interface UserService extends IService<User> {
    User findByName(String userName);

    void updateLoginTime(String username);
}
