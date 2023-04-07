package feichai.mybatis.service;

import feichai.mybatis.entity.TAuthority;
import feichai.mybatis.entity.TMyUser;
import feichai.mybatis.entity.mapper.AuthorityMapper;
import feichai.mybatis.entity.mapper.MyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

/**
 * 一般的，一个Controller对应一个Service，一个Service对应一个Dao，一个Dao对应一个数据库表，
 * 当然根据项目或业务复杂程度，一个Controller可以调用多个Service，而一个Service 也可以调用多个Dao，
 * 但是Controller层不允许互调，Service层也不允许互调，意思就是AController不能直接调用BController，
 * AService也不能直接去调用BService，遵循高内聚低耦合原则
 */
@Slf4j
@Service
@Primary
public class TMyUserDetailService implements UserDetailsService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TMyUser myUser = myUserMapper.findByUsername(username);

        if (myUser == null) {
            log.error("用户 {} 不存在!", username);
            throw new UsernameNotFoundException(String.format("用户 %s 不存在", username));
            // throw new UserNotExistException(String.format("用户 %s 不存在", username));
        }

        Set<TAuthority> authoritySet = authorityMapper.findByUserId(myUser.getId());

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (TAuthority authority : authoritySet) {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new User(
                myUser.getUsername(),
                myUser.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}
