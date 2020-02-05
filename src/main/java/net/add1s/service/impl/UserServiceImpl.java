package net.add1s.service.impl;

import net.add1s.entity.sys.User;
import net.add1s.mapper.UserMapper;
import net.add1s.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author mahoshojo
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserByUsername(String email) {
        return userMapper.findUserByUsername(email);
    }
}
