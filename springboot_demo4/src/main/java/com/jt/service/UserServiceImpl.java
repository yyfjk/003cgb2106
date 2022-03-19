package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User finUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> findUserByNS(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        return userMapper.selectList(queryWrapper);


    }

    @Override
    public List<User> findUserByNA(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", user.getName())
                .gt("age", user.getAge());
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> getUserByIds(Integer[] ids) {
        List<Integer> idList = Arrays.asList(ids);
        return userMapper.selectBatchIds(idList);
    }

    @Override
    public List<User> getUserBySA(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", user.getSex())
                .gt("age", user.getAge());
        return userMapper.selectList(queryWrapper);
    }

    //根据对象中不为空的属性充当where属性
    @Override
    public List<User> getUser(User user) {
        return userMapper.selectList(new QueryWrapper<>(user));
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    //arg1:set条件的数据
    //arg2:where条件的数据
    @Override
    public void updateUserByName(User user, String whereName) {
        //updateWrapper 与 queryWrapper 功能一样,可以混用
        UpdateWrapper<User> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("name", whereName);
        userMapper.update(user, updateWrapper);

    }

}


