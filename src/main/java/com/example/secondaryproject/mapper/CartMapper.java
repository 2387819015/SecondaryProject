package com.example.secondaryproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondaryproject.pojo.cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper extends BaseMapper<cart> {
    void deleteByUserId(@Param("userId") Integer userId);
    List<cart> selectCartByUserId(@Param("userId") Integer userId);
}
