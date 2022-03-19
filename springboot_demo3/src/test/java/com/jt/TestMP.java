package com.jt;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMP {

    @Autowired
    private UserMapper userMapper;

    /**
     * 完成数据的入库操作
     * 新增user数据(name="阿富汗",age=40,sex="厉害")
     * Sql: insert into demo_user value(xx,xx,xx,xx)
     * 思考: MP实现入库流程!!!
     * 选择A: 讲mp入库流程 理论为主.
     */
    @Test
    public void test01() {
        User user = new User();
        user.setName("阿富汗").setAge(40)
                .setSex("厉害");
        //以对象的方式操作数据!!!
        userMapper.insert(user);
        System.out.println("入库操作成功!!!!");
    }

    /**
     * 以mybatis的方式实现数据库查询
     * 1.实现user入库操作   insert into
     * 2.update  将name="阿富汗" 改为 name="塔利班"
     * 3.delete  将name="塔利班"数据删除.
     * 4.select  查询 name="小乔" 并且 性别 ="女"
     * 5.select  查询age < 18岁  性别="女"
     * 6.select  查询  name包含 '君'字的数据
     * 7.select  查询  sex="女"  按照年龄倒序排列.
     * 8.根据 name/sex 不为null的数据查询. 动态Sql!!
     * name="xxx" sex=null
     * name="xxx" sex="xx"
     * name=null  sex=null
     */

    //1.查询ID查询数据库 id=231  主键查询
    @Test
    public void selectById() {
        int id = 231;   //模拟用户参数.
        User user = userMapper.selectById(id);
        System.out.println(user);
    }

    /**
     * 2.查询 name="小乔" 并且 性别 ="女"
     * 思路: 如果将来有多个结果 则使用List进行接收.
     * Sql: select * from demo_user where name="小乔" and sex="女"
     * 注意事项: 默认的连接符  and
     */
    @Test
    public void select01() {
        //1.通过对象封装数据
        User user = new User();
        user.setName("小乔").setSex("女");
        //2.构建条件构造器 根据对象中不为null的属性充当where条件!
        QueryWrapper<User> queryWrapper = new QueryWrapper(user);
        //3.根据条件构造器 实现数据查询
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    //逻辑运算符：eq,>gt,<ly>ge,<le!=ne
    @Test
    public void select02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", "小乔")
                .eq("sex", "女");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    //查询age<18

    /**
     * 利用MP的方法实现
     */
    @Test
    public void select03() {
        List<User> userList = userMapper.findList(18, "女");
        System.out.println(userList);

        QueryWrapper<User> queryWrapper = new QueryWrapper();
        List<User> userList2 = userMapper.selectList(queryWrapper);


    }

    //查询名字包含君
    @Test
    public void select04() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "君");
        List<User> userList = userMapper.selectList(queryWrapper);
//        queryWrapper.likeRight("name","君");
//        List list = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    //     7.select  查询  sex="女"  按照年龄倒序排列.
    @Test
    public void select05() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sex", "女")
                .orderByDesc("age");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);


    }

    @Test
    public void select06() {
        String name = "貂蝉";
        int age = 0;
        boolean nameFlag = name == null ? false : true;
        boolean ageFlag = age == 0 ? false : true;
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq(nameFlag, "name", name)
                .eq(ageFlag, "age", age);
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    /**
     * 批量查询  查询id=1,4,5,6。的数据
     */
    @Test
    public void selectIn() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", 1, 4, 5, 6);
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);

//       List<Integer> ids=new ArrayList<>();
//       ids.add(1);
//       ids.add(4);
//       ids.add(5);
//       ids.add(6);
        //数组在未来由用户负责传递
        Integer[] array = new Integer[]{1, 4, 5, 6};
        //数组转换为List集合
        List<Integer> ids = Arrays.asList(array);

        List<User> userList1 = userMapper.selectBatchIds(ids);
        System.out.println(userList1);
    }

    /*
     * 9.查询性别为男的用户，只查询ID字段
     * 时机用途：  根据 业务只需要注解的查询
     * */
    @Test
    public void selectObjs() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", "男");
        List<Object> ids1 = userMapper.selectObjs(queryWrapper);
        System.out.println(ids1);
    }


}
