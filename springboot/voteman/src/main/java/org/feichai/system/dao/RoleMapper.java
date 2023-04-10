package org.feichai.system.dao;

import org.feichai.common.config.MyMapper;
import org.feichai.system.domain.Role;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    List<Role> findUserRole(String userName);
}