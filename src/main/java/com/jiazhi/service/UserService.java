package com.jiazhi.service;

import com.jiazhi.entity.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    boolean register(User user);

    boolean checkUserExists(String username);
    List<User> getAllUsers();}