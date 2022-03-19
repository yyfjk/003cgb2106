package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 *  1.规则1:继承BaseMapper时,必须添加泛型对象
 *  2.规则2:自己的方法不要与接口方法重名
 */
public interface UserMapper extends BaseMapper<User> {

    //查询所有的user用户
    List<User> findAll();


    List<User> findList(int i, String 女);
//    List<User> findList(Integer age,String sex);
}
