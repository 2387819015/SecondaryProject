package com.example.secondaryproject.controller;

import com.example.secondaryproject.service.Impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.secondaryproject.vo.result;
import com.example.secondaryproject.vo.cartVo;

import java.util.List;

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
        result.success("001",cartVoList);
        return result;
    }



}
