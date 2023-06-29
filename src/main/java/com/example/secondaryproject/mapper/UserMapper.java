package com.example.secondaryproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondaryproject.pojo.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<user> {
    int selectByAccountNumber(@Param("accountNumber") String accountNumber);

    int selectOne(@Param("accountNumber") String accountNumber,@Param("password") String password);//用于登录时，判断账号是否存在
}
