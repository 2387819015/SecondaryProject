package com.example.secondaryproject.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods_table")
public class goods {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String goodName;
    private String description;//商品描述
    private String face;//显示在商城里的图片
    private String price;
    private Integer num;
}