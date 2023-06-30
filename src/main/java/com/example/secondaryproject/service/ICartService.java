package com.example.secondaryproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondaryproject.pojo.cart;
import com.example.secondaryproject.vo.cartVo;

import java.util.List;

public interface ICartService extends IService<cart> {
    List<cartVo> selectCartByUserId(int userId);
}
