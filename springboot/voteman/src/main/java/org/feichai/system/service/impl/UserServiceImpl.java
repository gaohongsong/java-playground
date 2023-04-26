package org.feichai.system.service.impl;

import org.feichai.common.service.impl.BaseService;
import org.feichai.system.dao.UserMapper;
import org.feichai.system.domain.User;
import org.feichai.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> users = this.selectByExample(example);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void updateLoginTime(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", username.toLowerCase());
        User user = new User();
        user.setLastLoginTime(new Date());
        this.userMapper.updateByExample(user, example);
    }
}
