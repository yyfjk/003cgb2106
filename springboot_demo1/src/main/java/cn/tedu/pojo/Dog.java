package cn.tedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data//自动生成set,get方法
@NoArgsConstructor//无参构造
@AllArgsConstructor//全残构造
@Accessors(chain = true)//链式加载
public class Dog {
    private  String name;
    private  Integer age;
}
