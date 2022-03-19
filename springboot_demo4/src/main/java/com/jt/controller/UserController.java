package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //开启跨域机制
//@Controller
//@ResponseBody  将服务端的数据转化为json返回
public class UserController {
    @Autowired
    private UserService userService;

    /*
     * 查询所有的数据
     * URL:http://localhost:8090/findAll
     * */
    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    /*
     *规则springMVC
     * URL地址:http://localhost:8090/findUserById?id=1
     * 请求类型：GET/POST/PUT/DELETE
     * 参数：id=1
     * 参数说明：
     *   1.参数的名称必须与URL中的名称一致
     *   2.springMVC可以根据用户的需求，自动实现类型转换
     *       实现底层：springMVC所有的参数默认都是string类型
     *           更具用户参数的类型，自动实现转换
     *
     * */
//    @RequestMapping("/findUserById")//只允许接收get类型
    @GetMapping("/findUserById")
    public User findUserBId(Integer id) {
        return userService.finUserById(id);

    }

    //    http://localhost:8090/findUserByNS?name=小法&sex=男
    @GetMapping("/findUserByNS")
    public List<User> findUserByNS(User user) {


        return userService.findUserByNS(user);
    }
    /*
    *后端服务器接收的规则：
    * 1.参数与参数之后使用/分割
    * 2.参数的位置一但确定。一般不变
    * 3.接受的参数使用{形参变量}
    * 4.
    * RESTFul案列
    * URL：http://localhost:8090/user/貂蝉/10
    * 参数：name/age
    * 返回值：返回List<User>
    * 使用 @PathVariable接收
    * 5.如果参数有多个使用参数接收
    * */

 @GetMapping("/user/{name}/{age}")
    public  List<User> findUserByNA(User user){

     return  userService.findUserByNA(user);

    }



    @GetMapping("/getUserByIds")
    public List<User> getUserByIds(Integer[] ids){

        return userService.getUserByIds(ids);
    }







    /*@GetMapping("/user/{name}/{age}")
    public  List<User> findUserByNA(@PathVariable String name,
                                    @PathVariable Integer age){
        System.out.println(name);
        System.out.println(age);

        return null;


    }*/



}
