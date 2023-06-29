package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.mapper.PictureMapper;
import com.example.secondaryproject.pojo.picture;
import com.example.secondaryproject.service.IPictureService;
import org.springframework.stereotype.Service;

@Service
public class PictureService extends ServiceImpl<PictureMapper, picture> implements IPictureService {
}
