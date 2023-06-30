package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.mapper.CartMapper;
import com.example.secondaryproject.pojo.cart;
import com.example.secondaryproject.service.ICartService;
import org.springframework.stereotype.Service;

@Service
public class CartService extends ServiceImpl<CartMapper, cart> implements ICartService {

}
