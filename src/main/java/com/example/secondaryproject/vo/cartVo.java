package com.example.secondaryproject.vo;

import lombok.Data;

@Data
public class cartVo {
    //购物车
    private Integer goodsId;
    private String goodsName;
    private Integer goodsNum;
    private Double totalPrice;
    private String goodsPic;
}
