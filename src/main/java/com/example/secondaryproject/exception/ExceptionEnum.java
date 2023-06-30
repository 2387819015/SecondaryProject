package com.example.secondaryproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    GET_PRODUCT_ERROR(002, "商品查询失败"),
    GET_PRODUCT_NOT_FOUND(002, "商品为空"),
    GET_PRODUCT_PICTURE_ERROR(002, "商品图片查询失败"),
    GET_PRODUCT_PICTURE_NOT_FOUND(002, "商品图片为空"),
    GET_CATEGORY_NOT_FOUND(002, "分类查询为空"),
    GET_USER_NOT_FOUND(002, "用户名或密码错误"),
    SAVE_USER_REUSE(002, "用户名已存在"),
    SAVE_USER_ERROR(002, "注册用户失败"),
    GET_CART_ERROR(002, "购物车异常"),
    GET_CART_NOT_FOUND(002, "购物车为空"),
    UPDATE_CART_ERROR(003, "商品数量修改失败"),
    DELETE_CART_ERROR(003, "商品删除失败"),
    ADD_ORDER_ERROR(002, "生成订单失败"),
    GET_ORDER_NOT_FOUND(002, "订单为空"),
    GET_ORDER_ERROR(002, "查询订单失败"),
        ;
    private int code;
    private String msg;
}
