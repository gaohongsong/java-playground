package org.feichai.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.domain.QueryRequest;
import org.feichai.common.service.impl.BaseService;
import org.feichai.common.util.MD5Utils;
import org.feichai.system.dao.UserMapper;
import org.feichai.system.dao.UserRoleMapper;
import org.feichai.system.domain.User;
import org.feichai.system.domain.UserRole;
import org.feichai.system.service.UserRoleService;
import org.feichai.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseService<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> users = this.selectByExample(example);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    @Transactional
    public void updateLoginTime(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        User user = new User();
        user.setLastLoginTime(new Date());
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    public List<User> findUserWithDept(User user, QueryRequest request) {
        try {
            return this.userMapper.findUserWithDept(user);
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void addUser(User user, Long[] roles) {
        user.setCrateTime(new Date());
        user.setTheme(User.DEFAULT_THEME);
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        this.save(user);

        setUserRoles(user, roles);

    }

    @Override
    public void deleteUsers(String userIds) {
        List<String> ids = Arrays.asList(userIds.split(","));
        this.batchDelete(ids, "userId", User.class);
        this.userRoleService.deleteUserRolesByUserId(userIds);
    }

    private void setUserRoles(User user, Long[] roles) {
        Arrays.stream(roles).forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            this.userRoleMapper.insert(userRole);
        });
    }
}
