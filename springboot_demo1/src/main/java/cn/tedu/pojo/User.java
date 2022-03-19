package cn.tedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//标准写法
//知识点：为什么需要添加无参构造???
//     利用反射机制实例化对象时，默认调用无参构造

@Data//自动生成set,get方法
@NoArgsConstructor//无参构造
@AllArgsConstructor//全残构造
@Accessors(chain = true)//链式加载

public class User implements Serializable {
    private Integer id;
    private String name;

    void  add(){
        User user=new User();
        user.setId(1111).setName("aaaa");


    }
}
