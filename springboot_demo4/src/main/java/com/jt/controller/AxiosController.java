package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/axios")
public class AxiosController {
    @Autowired
    private UserService userService;

    /*
     * url:http://localhost:8090/axios/getUserById?id=1
     * */
    @GetMapping("/getUserById")
    public User getUserById(Integer id) {
        return userService.finUserById(id);
    }

    /*
     * GET测试2： restFull结构接收参数
     * http://localhost:8090/axios/axios/user/女/18
     * 返回值list集合
     * */
    @GetMapping("/user/{sex}/{age}")
    public List<User> getUserBySA(User user) {
        return userService.getUserBySA(user);

    }

    /*
     *GET测试3： 利用对象的方式接收参数
     * URL|: http://localhost:8090/getUser?name=xx&sex=&age=xx
     * 参数| name/age/sex
     *
     *
     * */
    @GetMapping("/getUser")
    public List<User> getUser(User user) {
        return userService.getUser(user);
    }

    //url:url="http://localhost:8090/axios/deleteById?id=232"
    @DeleteMapping("/deleteById")
    public String deleteById(Integer id) {
        userService.deleteById(id);
        return "删除数据成功";
    }
    /*
    * 实现用户的入库操作
    * URL:http://localhost:8090/axios/saveUser
    * 参数
    * 返回值String  新增成功
    *   json == user 对象
    * 1.user对象可以转换为json  ResponseBody
    * json转换为user对象   @RequestBody
    * */
    @PostMapping("/saveUser")
    public  String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return  "新增成功";

    }
    @PutMapping("/updateUser")
    public String updateUser (@RequestBody User user) {
        userService.updateUser(user);
        return "更改成功";
    }

    /*
    * 需求:
    *
    *
    * 注意事项：rstFull可以为对象的属性赋值
    *           注意：restFull的名称不要于属性重名，否则会覆盖
    *           引发bug
    * */
    @PutMapping("/updateUserByName/{whereName}")
    public String updateByName(@RequestBody User user,
                               @PathVariable String whereName){

        userService.updateUserByName(user,whereName);
        return "修改数据成功2222";
    }

}





