package com.jt.test;

import com.jt.test.mapper.UserMapper;
import com.jt.test.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatis {
@Autowired
    private UserMapper userMapper;
@Test
    public void  test01(){
    List<User> userList = userMapper.findAll();
    System.out.println(userList);
}


}

