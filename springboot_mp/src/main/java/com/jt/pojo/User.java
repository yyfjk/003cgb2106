package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("demo_user")//对象与表名映射
public class User implements Serializable {//demo_user
    /*
    * 规则：
    * 如果我们数据库中的字段与表中的属性名称一致则可以省略不写
    * 2.如果对象与表名一致，则名称可以省略
    * */
    @TableId(type = IdType.AUTO)//主键自增长
//    @TableField("id")  实现
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
