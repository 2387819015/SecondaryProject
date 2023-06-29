package com.example.secondaryproject.controller;

import com.example.secondaryproject.pojo.picture;
import com.example.secondaryproject.service.Impl.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.secondaryproject.vo.result;

import java.util.List;

@RestController
@RequestMapping("/GoodsPicture")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private result result;

    @PostMapping("/goods/{goodsId}")
    public result goodsPicture(@PathVariable Integer goodsId){
        List<picture> goodsPicture = pictureService.getGoodsPictureByGoodsId(goodsId);
        result.success("001",goodsPicture);
        return result;
    }
}
