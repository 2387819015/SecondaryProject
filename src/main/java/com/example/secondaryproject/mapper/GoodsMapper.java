package com.example.secondaryproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondaryproject.pojo.goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper extends BaseMapper<goods> {
    List<goods> selectGoodsByName(@Param("goodsName") String goodsName);
}
