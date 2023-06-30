package com.example.secondaryproject.controller;

import com.example.secondaryproject.service.Impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.secondaryproject.vo.result;

@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private result result;
    @Autowired
    private CartService cartService;

}
