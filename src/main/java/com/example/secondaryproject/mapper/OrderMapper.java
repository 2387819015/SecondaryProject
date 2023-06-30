package com.example.secondaryproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondaryproject.pojo.order;
import com.example.secondaryproject.vo.orderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<order> {
    List<order> selectOrderByUserId(@Param("userId") int userId);
}
