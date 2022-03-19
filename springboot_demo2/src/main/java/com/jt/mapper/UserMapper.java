package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper //将该接口交给Spring管理,spring创建对象
public interface UserMapper {

    //查询所有的user用户
    List<User> findAll();

}
