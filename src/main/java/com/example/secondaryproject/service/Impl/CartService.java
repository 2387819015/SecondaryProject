package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.exception.ExceptionEnum;
import com.example.secondaryproject.exception.XmException;
import com.example.secondaryproject.mapper.CartMapper;
import com.example.secondaryproject.mapper.GoodsMapper;
import com.example.secondaryproject.pojo.cart;
import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.service.ICartService;
import com.example.secondaryproject.vo.cartVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService extends ServiceImpl<CartMapper, cart> implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public List<cartVo> selectCartByUserId(int userId){
        List<cartVo> cartVoList = new ArrayList<>();
        List<cart> cartList = new ArrayList<>();
        cartList = cartMapper.selectCartByUserId(userId);
        if(cartList == null){
            throw new XmException(ExceptionEnum.GET_CART_ERROR);
        }
        for(cart cart:cartList){
            cartVo cartVo = new cartVo();
            BeanUtils.copyProperties(cart,cartVo);
            goods goods = goodsMapper.selectById(cart.getGoodsId());
            cartVo.setGoodsName(goods.getGoodName());
            cartVo.setTotalPrice(cartVo.getGoodsNum()*goods.getPrice());
            cartVo.setGoodsPic(goods.getFace());
            cartVoList.add(cartVo);
        }
        return cartVoList;
    }

    public cartVo addCart(cart cart){
        cartMapper.insert(cart);
        cartVo cartVo = new cartVo();
        BeanUtils.copyProperties(cart,cartVo);
        goods goods = goodsMapper.selectById(cart.getGoodsId());
        cartVo.setGoodsName(goods.getGoodName());
        cartVo.setTotalPrice(cartVo.getGoodsNum()*goods.getPrice());
        cartVo.setGoodsPic(goods.getFace());
        return  cartVo;
    }

    public void deleteCart(cartVo cartVo,int userId){
        cart cart = new cart();
        BeanUtils.copyProperties(cartVo,cart);
        cart.setUserId(userId);
        cartMapper.deleteCart(cart.getGoodsId(),cart.getGoodsNum(),cart.getUserId());
    }
}
