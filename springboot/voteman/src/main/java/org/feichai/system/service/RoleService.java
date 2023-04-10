package org.feichai.system.service;

import org.feichai.common.service.IService;
import org.feichai.system.domain.Role;

import java.util.List;

public interface RoleService extends IService<Role> {
    List<Role> findUserRole(String userName);
}
