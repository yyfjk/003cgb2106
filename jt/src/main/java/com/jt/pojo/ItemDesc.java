package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 杨永峰
 * 时间 2021/10/31
 */
@Data
@Accessors(chain = true)
@TableName("item_desc")
public class ItemDesc extends BasePojo{
    //由于item。id=itemDesc.id  使用id不能主动自增
@TableId
    private Integer id;
    private String itemDesc;

}
