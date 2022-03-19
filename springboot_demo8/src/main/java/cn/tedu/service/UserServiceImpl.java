package cn.tedu.service;

import cn.tedu.mapper.UserMapper;

import cn.tedu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User finUserById(Integer id) {
        return userMapper.selectById(id);
    }



}
