package com.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
//序列化接口作用: 保证对象网络传输的有效性!!!
public class User implements Serializable {
    private Integer id;
    private String  name;
    private Integer age;
    private String  sex;
}
