package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.mapper.GoodsMapper;
import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, goods> implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    public List<goods> selectGoodsByName(String goodsName){
        List<goods> lg = new ArrayList<>();
        lg = goodsMapper.selectGoodsByName(goodsName);
        return lg;
    }
}
