package com.example.secondaryproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondaryproject.pojo.goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsService extends IService<goods> {
    List<goods> selectGoodsByName(String goodsName);
}
