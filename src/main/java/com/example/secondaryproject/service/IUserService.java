package com.example.secondaryproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondaryproject.pojo.user;

public interface IUserService extends IService<user> {
    void register(user user);
    boolean login(user user);
}
