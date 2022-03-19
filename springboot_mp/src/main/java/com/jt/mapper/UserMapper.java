package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;

import java.util.List;
//将该接口交给Spring容器管理
//@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查询demo_user表中的所有数据
    List<User> findAll();

}
