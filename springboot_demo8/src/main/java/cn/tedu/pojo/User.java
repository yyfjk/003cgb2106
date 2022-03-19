package cn.tedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
//1.将对象与表进行关联
//规则1: 如果表名与对象名一致    则名称可以省略
//规则2: 如果字段名与属性名一致, 则注解可以省略
@TableName("demo_user")
public class User implements Serializable {
    //2.主键自增/非空/UUID 生成唯一编号
    @TableId(type=IdType.AUTO)
    private Integer id;
    //3.标识属性与字段的映射.
    @TableField("name")
    private String  name;
    private Integer age;
    private String  sex;
}
