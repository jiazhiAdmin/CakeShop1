package com.jiazhi.service.impl;

import com.jiazhi.entity.User;
import com.jiazhi.mapper.UserMapper;
import com.jiazhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }
    @Override
    public boolean register(User user) {
        int result = userMapper.insert(user);
        return result > 0;
    }
    @Override
    public boolean checkUserExists(String username) {
      return  userMapper.checkUserExists(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}