package cn.tedu.config;

import cn.tedu.pojo.Dog;
import cn.tedu.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //标识是一个配置类
public class UserConfig {
    /**
     * 思路：
     *      1Spring内部维护一个Map集合
     *      2.Map集合 key/value  分别是谁？
     *      3.Ioc管理的对象方式   1.@Controller等注解
     * 1.注解组合：@configuration
     * 2.什么是bean???
     * 2.@Bean注解的作用
     *          将方法的返回值的对象交给spring管理
     * 4.spring如何管理对象?
     *   数据结构：Map的集合    Map(k,v)
     * key:对象的id
     * value：实例化之后的对象
     * demo:
     *      Map<userA,new User()></>
     *
     *
     *demo2:
     *      @Controller
     *      HelloController()
     *      key:helloController
     *      value:spring通过反射创建的HelloController对象
     * @return
     * */
    @Bean
    public User user() {
        return new User(101, "好好学习");

    }
    @Bean
    public Dog dog(){
        return  new Dog("小天",18);
    }
}
