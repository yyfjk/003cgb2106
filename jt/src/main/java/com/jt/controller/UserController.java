package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll() {

        return userService.findAll();

    }

    /**
     * 需求: 根据u/p查询数据库,返回秘钥token
     * URL: /user/login
     * 类型: post
     * 参数: username/password json
     * 返回值: SysResult对象(token)
     */
    @PostMapping("/login")
    public SysResult login(@RequestBody User user) {

        String token = userService.findUserByUP(user);
        if (token == null || "".equals(token)) {
            //表示我们的用户名和密码的错误
            return SysResult.fail();
        }

        //表示用户名和密码正确，返回密钥信息
        return SysResult.success(token);

    }


    /*
     * 需求：利用分页查询用户信息
     * URL：/user/list
     * 参数：http://localhost:8091/user/list?query=查询关键
     * 返回值:SysResult(pageResult)
     *
     *
     * */
    @GetMapping("/list")
    public SysResult getUserListByPage(PageResult pageResult) {
        pageResult = userService.getUserListByPage(pageResult);
        return SysResult.success(pageResult);

    }

    /*
     * 状态修改业务接口
     * 请求类型PUT
     * 请求参数据：用户id的状态值数据/status
     * 请求路劲/user/status/{id}/{status}
     * 返回值SysResult对象
     * */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatusById(User user) {
        userService.updateStatusById(user);
        return SysResult.success();
    }


    /*
     * 用户新增
     * 请求类型：
     *URL:/user/addUser
     * 参数/js对象经过浏览器解析编程json串
     * /addUser
     * 返回值：SysResult对象
     *  对象转化为json
     * */
    @PostMapping("/addUser")
    public SysResult saveUser(@RequestBody User user) {

        userService.saveUser(user);
        return SysResult.success();
    }

    /*
     * 业务：根据id查询用户数据
     * URL:/user/{id}
     * c
     *参数：id
     * 返回值:SysResult对象
     * */
    @GetMapping("/{id}")
    public SysResult findUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return SysResult.success(user);
    }

    /*
     * 用户的修改操作
     * URL:/user.updateUser
     * 参数： id/phone/email
     * 返回值：SysResult对象
     *
     * */
    @PutMapping("/updateUser")
    public SysResult updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return SysResult.success();
    }

    /*
     * 删除数据
     * URL：/user/{id}
     * 参数： id
     * 返回值：SysResult
     *
     * */
    @DeleteMapping("/{id}")
    public SysResult deleteById(@PathVariable Integer id) {
        //为了防止MP的方法冲突 业务放方法最好添加业务的名称

        return SysResult.fail();
    }


}


