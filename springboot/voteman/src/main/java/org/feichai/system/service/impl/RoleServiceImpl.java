package org.feichai.system.service.impl;

import org.feichai.common.service.impl.BaseService;
import org.feichai.system.dao.RoleMapper;
import org.feichai.system.domain.Role;
import org.feichai.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findUserRole(String userName) {
        return roleMapper.findUserRole(userName);
    }
}
