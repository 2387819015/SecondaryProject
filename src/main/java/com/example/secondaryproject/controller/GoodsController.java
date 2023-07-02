package com.example.secondaryproject.controller;

import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.service.Impl.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.secondaryproject.vo.result;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private result result;
    @PostMapping("/select")
    public result selectGoodsByName(String goodsName){
        List<goods> lg = new ArrayList<>();
        lg = goodsService.selectGoodsByName(goodsName);
        result.success("001",lg);
        return result;
    }
}
