package com.example.secondaryproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondaryproject.pojo.picture;

import java.util.List;

public interface IPictureService extends IService<picture> {
    List<picture> getGoodsPictureByGoodsId(Integer goodsId);
}
