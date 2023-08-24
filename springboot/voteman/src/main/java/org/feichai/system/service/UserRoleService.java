package org.feichai.system.service;

import org.feichai.common.service.IService;
import org.feichai.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {
    void deleteUserRolesByUserId(String userIds);
}
