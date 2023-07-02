package com.example.secondaryproject.controller;

import com.example.secondaryproject.pojo.cart;
import com.example.secondaryproject.service.Impl.CartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.secondaryproject.vo.result;
import com.example.secondaryproject.vo.cartVo;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private result result;
    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public result cart(@PathVariable int userId){

        List<cartVo> cartVoList = cartService.selectCartByUserId(userId);

        System.out.println(userId);

        result.success("001",cartVoList);
        return result;
    }

    @PostMapping("/addCart")
    public result addCart(@RequestBody cart cart){
        cartVo cartVo = cartService.addCart(cart);
        result.success("001","添加购物车成功!",cartVo);
        return result;
    }

    @DeleteMapping("/deleteCart/{userId}")
    public result deleteCart(@RequestBody cartVo cartVo,@PathVariable int userId){
        cartService.deleteCart(cartVo,userId);
        result.success("001","删除成功！");
        return result;
    }

}
