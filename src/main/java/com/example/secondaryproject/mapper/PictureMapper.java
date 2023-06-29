package com.example.secondaryproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondaryproject.pojo.picture;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMapper extends BaseMapper<picture> {
    List<picture> selectPicByGoodsId(@Param("goodsId") Integer goodsId);
}
