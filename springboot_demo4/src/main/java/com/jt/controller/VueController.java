package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vue")
public class VueController {

    @Autowired
    private UserService userService;

    /**
     * 需求: 查询所有的用户数据
     * URL: http://localhost:8090/vue/findAll
     * 参数: null
     * 返回值: List<User>
     */
    @GetMapping("/findAll")
    public List<User> findAll(){

        return userService.findAll();
    }

    /**
     * 业务:  实现用户入库
     * URL: http://localhost:8090/vue/saveUser
     * 参数: User对象的JSON
     * 返回值: 成功信息
     */
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){

        userService.saveUser(user);
        return "入库成功!!!";
    }

    /**
     * 业务: 根据id删除数据
     * URL: http://localhost:8090/vue/deleteUserById?id=1
     * 参数: id=1
     * 返回值: 删除成功.
     */
    @DeleteMapping("/deleteUserById")
    public String deleteUserById(Integer id){

        userService.deleteById(id);
        return "删除数据成功!!!";
    }
}