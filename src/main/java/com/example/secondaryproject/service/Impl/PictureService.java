package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.exception.ExceptionEnum;
import com.example.secondaryproject.exception.XmException;
import com.example.secondaryproject.mapper.PictureMapper;
import com.example.secondaryproject.pojo.picture;
import com.example.secondaryproject.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService extends ServiceImpl<PictureMapper, picture> implements IPictureService {
    @Autowired
    private PictureMapper pictureMapper;
    public List<picture> getGoodsPictureByGoodsId(Integer goodsId){
        List<picture> list = new ArrayList<>();
        list = pictureMapper.selectPicByGoodsId(goodsId);
        if(list == null){
            throw new XmException(ExceptionEnum.GET_PRODUCT_PICTURE_NOT_FOUND);
        }
        return list;
    }
}
