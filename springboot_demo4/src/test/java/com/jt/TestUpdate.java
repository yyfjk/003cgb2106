package com.jt;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUpdate {
    @Autowired
    private UserMapper userMapper;
@Test
    public void testUpdate() {
        User user = new User();
        user.setId(231).setName("车曾").setAge(10).setSex("男");
        //byId只当作where条件
        //其他不为null的属性当作set属性
        userMapper.updateById(user);

    }
//    将name='阿富汗'改为name="塔利班"
    //update(arg1,arg2)
    //arg1:实体对象    set条件数据
    //arg2:
    @Test
    public  void testUpdate2(){
    User user=new User();
    user.setName("塔利班").setAge(40).setSex("911");
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("name", "阿富汗");

    userMapper.update(user,updateWrapper);
        System.out.println("数据更新成功");
    }
}
