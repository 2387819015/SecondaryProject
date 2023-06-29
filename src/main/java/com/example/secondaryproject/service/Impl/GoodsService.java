package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.mapper.GoodsMapper;
import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.service.IGoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, goods> implements IGoodsService {
}
