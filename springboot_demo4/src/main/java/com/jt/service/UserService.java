package com.jt.service;

import com.jt.pojo.User;

import java.util.List;

public interface UserService {



    List<User>
    findAll();

    User finUserById(Integer id);


    List<User> findUserByNS(User user);

    List<User> findUserByNA(User user);


    List<User> getUserByIds(Integer[] ids);

    List<User> getUserBySA(User user);

    List<User> getUser(User user);


    void deleteById(Integer id);

    void saveUser(User user);


    void updateUser(User user);

    void updateUserByName(User user, String whereName);
}

