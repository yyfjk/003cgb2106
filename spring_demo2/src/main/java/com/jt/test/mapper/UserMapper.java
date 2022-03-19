package com.jt.test.mapper;

import com.jt.test.pojo.User;

import java.util.List;

public interface UserMapper {

    //查询所有的user用户
    List<User> findAll();
}
