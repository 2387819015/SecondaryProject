package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.mapper.GoodsMapper;
import com.example.secondaryproject.mapper.OrderMapper;
import com.example.secondaryproject.mapper.UserMapper;
import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.pojo.order;
import com.example.secondaryproject.service.IOrderService;
import com.example.secondaryproject.vo.cartVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, order> implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public void addOrder(List<cartVo> cartvoList, int userId){
        long time = new Date().getTime();
        for(cartVo cartVo:cartvoList){
            order order = new order();
            BeanUtils.copyProperties(cartVo,order);
            order.setId(userId);
            order.setOrderTime(time);
            order.setUserName(userMapper.selectById(userId).getNickName());
            orderMapper.insert(order);
            goods goods = goodsMapper.selectById(order.getGoodsId());
            goods.setNum(goods.getNum()-order.getGoodsNum());
            goods.setSaleNum(goods.getSaleNum()+order.getGoodsNum());
            goodsMapper.updateById(goods);
        }
    }
}
