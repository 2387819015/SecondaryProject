package com.example.secondaryproject.controller;

import com.example.secondaryproject.pojo.goods;
import com.example.secondaryproject.service.Impl.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.secondaryproject.vo.result;
import java.util.ArrayList;
import java.util.List;

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
