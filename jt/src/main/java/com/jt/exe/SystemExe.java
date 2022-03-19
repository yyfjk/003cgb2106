package com.jt.exe;

import com.jt.vo.SysResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * 1.标识：该类是全局异常处理机制
 * 通知：aop中的技术，解决了特定问题的
 * */
@RestControllerAdvice   //返回值返回的都是json串
@ControllerAdvice
public class SystemExe {
    /*
     * 说明：需要为全局异常定义一个方法。
     * 需求：返回的统一业务的数据，SysResult
     * 拦截：指定遇到的某种异常实现AOP处理
     *特点：该异常处理的机制只拦截Controller层的异常
     * */
    @ExceptionHandler({RuntimeException.class})
    public SysResult fill(Exception e){
        e.printStackTrace();
        return  SysResult.fail();


    }

}
