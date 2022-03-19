package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;


//效果：只要@Test测试方法执行，则整个Spring容器启动
//注意事项：该注解只能在测试类中使用。测试类的包路径必须在主启动类的同包或子包中编辑

@SpringBootTest
class SpringbootSsmApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /*
     * MP入门案列
     * 查询id=1的用户
     * 根据对象中不为null的属性业务操作
     * 语法：
     *    1.QueryWrapper条件构造器
     * 例子：
     * select * from demo_user where xx=xx and xx=xx
     * */
    @Test
    public void insertUser() {
        User user = new User();
        user.setId(null).setName("MybatisPlus").setAge(10).setSex("男");
        userMapper.insert(user);


    }

    @Test
    public void selectById() {
        int id = 1;
        User user = userMapper.selectById(id);
        System.out.println(user);


    }

    @Test
    public void selectByNS() {
        User user = new User();
        user.setName("大乔").setSex("女");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        queryWrapper.eq("name", "大乔").eq("sex", "女");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /*
     * 需求:age>18的用户，并且性别=男性
     * */
    @Test
    public void selectByAE() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 18).eq("sex", "男");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /*
     * 需求:查询name中包含"君",新性别=‘女’
     * SQL： where like "%君%"
     * 需求2：查询name中的以“君”结尾的，性别=“女”
     * */
    @Test
    public void selectLike() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name","君")
        queryWrapper.likeLeft("name", "君")
                .eq("sex", "女");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /*
     * 需求：查询id=1,3,4,5的数据-并且按照年龄降序排列
     * */
    @Test
    public void selectIds() {
        Integer[] ids = {1, 3, 4, 5};
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids)
                .orderByDesc("age");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /*
     * 只想获取第一列数据
     *
     * */
    @Test
    public void selectObjs() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex","女");
        List<User> list =userMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    /*
    * 说明：根据不为n岁，ull的属性当做where动态SQL实现
    * 需求：查询age>18 sex=女的用户
    *
    * */
    @Test
    public void selectList2() {
        Integer age=null;
        String sex="女";
        boolean flag = StringUtils.hasLength(sex);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt(age!=null,"age",age)
                .eq(flag,"sex",sex);
        List<User> list =userMapper.selectList(queryWrapper);
        System.out.println(list);
    }
}