package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.exception.ExceptionEnum;
import com.example.secondaryproject.exception.XmException;
import com.example.secondaryproject.mapper.CartMapper;
import com.example.secondaryproject.mapper.GoodsMapper;
import com.example.secondaryproject.mapper.OrderMapper;
import com.example.secondaryproject.mapper.UserMapper;
import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.pojo.order;
import com.example.secondaryproject.service.IOrderService;
import com.example.secondaryproject.vo.cartVo;
import com.example.secondaryproject.vo.orderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, order> implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional
    public void addOrder(List<cartVo> cartvoList, int userId){
        long time = new Date().getTime();
        for(cartVo cartVo:cartvoList){
            order order = new order();
            BeanUtils.copyProperties(cartVo,order);
            order.setUserId(userId);
            order.setUserName(userMapper.selectById(userId).getNickName());
            System.out.println(order.toString());
            try {
                orderMapper.insert(order);
            } catch (Exception e) {
                e.printStackTrace();
                throw new XmException(ExceptionEnum.ADD_ORDER_ERROR);
            }
            goods goods = goodsMapper.selectById(order.getGoodsId());
            goods.setNum(goods.getNum()-order.getGoodsNum());
            goods.setSaleNum(goods.getSaleNum()+order.getGoodsNum());
            goodsMapper.updateById(goods);
        }

        try {
            cartMapper.deleteByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new XmException(ExceptionEnum.ADD_ORDER_ERROR);
        }
    }

    public List<orderVo> getOrder(int userId){
        List<orderVo> orderVoList = new ArrayList<>();
        List<order> orderList = new ArrayList<>();
        orderList = orderMapper.selectOrderByUserId(userId);
        if(orderList == null){
            throw new XmException(ExceptionEnum.GET_ORDER_NOT_FOUND);
        }
        for(order order:orderList){
            orderVo orderVo = new orderVo();
            orderVo.setGoodsName(order.getGoodsName());
            orderVo.setGoodsPic(goodsMapper.selectOneByName(order.getGoodsName()).getFace());
            orderVoList.add(orderVo);
        }
        return orderVoList;
    }
}
