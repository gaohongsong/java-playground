package org.feichai.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.service.impl.BaseService;
import org.feichai.system.domain.UserRole;
import org.feichai.system.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {
    @Override
    public void deleteUserRolesByUserId(String userIds) {
        List<String> ids = List.of(userIds.split(","));
        this.batchDelete(ids, "userId", UserRole.class);
    }
}
