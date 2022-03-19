package cn.tedu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController//将该类交给Spring管理
//spring负责加载指定的配置文件
//如果注解只有一个属性名称为value，则可以省略不写
@PropertySource(value = "classpath:/msg.properties",encoding = "utf-8")
public class hello {
    /**
     * 规则：
     *      1. 当spring容器启动时会加载yml配置文件，
     *      会将内部的key-value结构，加载到spring维护的内存空间
     *      2.@value功能，主要是从spring容器中根据key 动态赋值
     *      3.spring表达式 简称spel
     *
     * */
    @Value("${msg.hello}")
    private String msg;
    @Value("${pro.msg}")
    private  String proMsg;

    @RequestMapping("/get")

public  String get(){
        return  msg+proMsg;
    }
}
