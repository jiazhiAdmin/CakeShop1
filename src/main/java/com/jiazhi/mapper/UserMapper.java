package com.jiazhi.mapper;

import com.jiazhi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    // 查询用户是否存在
    boolean checkUserExists(String username);

    List<User> getAllUsers();
}
