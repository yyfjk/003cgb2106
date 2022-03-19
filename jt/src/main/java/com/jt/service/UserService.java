package com.jt.service;

import com.jt.pojo.User;
import com.jt.vo.PageResult;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String findUserByUP(User user);

    PageResult getUserListByPage(PageResult pageResult);

    void updateStatusById(User user);

    void saveUser(User user);

    User findUserById(Integer id);

    void updateUser(User user);


    void deleteUserById(Integer id);
}
