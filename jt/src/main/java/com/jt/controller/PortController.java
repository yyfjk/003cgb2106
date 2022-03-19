package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

//动态获取端口号
public class PortController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getPort")
    public String getPort() {
        return "当前端口号" + port;

    }

}
