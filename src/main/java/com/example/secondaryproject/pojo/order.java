package com.example.secondaryproject.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_table")
public class order {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String userName;
    private String goodsName;
    private Integer goodsNum;
    private Double totalPrice;
    private long orderTime;
}
