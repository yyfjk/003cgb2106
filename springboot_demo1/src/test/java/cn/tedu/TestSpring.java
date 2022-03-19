package cn.tedu;


import cn.tedu.pojo.Dog;
import cn.tedu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 原理说明:
 * 1.当测试类执行时，会根据Spring的配置动态启动Spring容器
 * 2.当spring容器启动时，会加载所有的注解和配置类，最终将所有的对象
 * 交给spring容器管路，Map集合
 * 3.@SpringBootTest通过这个注解，可以
 */


@SpringBootTest
public class TestSpring {


    @Autowired
//    @Qualifier(value = "user")
    private User user;

    @Autowired
    private Dog dog;


    @Test
    public void testUser() {
        System.out.println(user.toString());
    }


    @Test
    public void testDog(){
        System.out.println(dog);
    }

}
