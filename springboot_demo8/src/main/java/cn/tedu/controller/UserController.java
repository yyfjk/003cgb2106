package cn.tedu.controller;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findUserById")
    public User findUserBId(Integer id) {
        return userService.finUserById(id);

    }


}
