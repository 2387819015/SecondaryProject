package com.example.secondaryproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondaryproject.pojo.order;
import com.example.secondaryproject.vo.cartVo;
import com.example.secondaryproject.vo.orderVo;

import java.util.List;

public interface IOrderService extends IService<order> {
    void addOrder(List<cartVo> cartVoList, int userId);

    List<orderVo> getOrder(int userId);
}
