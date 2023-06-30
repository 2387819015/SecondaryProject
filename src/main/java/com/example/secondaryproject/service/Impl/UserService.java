package com.example.secondaryproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondaryproject.exception.ExceptionEnum;
import com.example.secondaryproject.exception.XmException;
import com.example.secondaryproject.mapper.UserMapper;
import com.example.secondaryproject.pojo.user;
import com.example.secondaryproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, user> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    public void register(user user){
        //用户注册
        if(userMapper.selectByAccountNumber(user.getAccountNumber())!= 0){
            throw new XmException(ExceptionEnum.SAVE_USER_REUSE);
        }
        userMapper.insert(user);
    }

    public boolean login(user user){
        if(userMapper.selectOne(user.getAccountNumber(),user.getPassword())!=0){
            return true;
        }
        else{
            throw new XmException(ExceptionEnum.GET_USER_NOT_FOUND);
        }
    }
}
