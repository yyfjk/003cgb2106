package com.jt.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jt.mapper")
public class RunAPP {

    public static void main(String[] args) {

        SpringApplication.run(RunAPP.class,args);
    }
}
