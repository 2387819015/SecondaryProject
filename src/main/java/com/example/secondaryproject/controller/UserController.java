package com.example.secondaryproject.controller;

import com.example.secondaryproject.service.Impl.UserService;
import com.example.secondaryproject.vo.result;
import io.leopard.web.servlet.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.example.secondaryproject.pojo.user;
import com.example.secondaryproject.util.BeanUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private result result;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/register")
    public result register(@RequestBody user user){
        userService.register(user);
        result.success("001","注册成功");
        return result;
    }

    @PostMapping("/login")
    public result login(@RequestBody user user, HttpServletRequest request, HttpServletResponse response){
        if(!userService.login(user)){
            //账号不存在，抛出异常
        }
        String encode = user.getAccountNumber()+"|"+user.getPassword();
        CookieUtil.setCookie("token",encode,3600,request,response);

        try {
            redisTemplate.opsForHash().putAll(encode, BeanUtil.beanMap(user));
            redisTemplate.expire(encode, 60 * 60, TimeUnit.SECONDS); // 设置过期时间
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setPassword(null);
        result.success("001", "登录成功", user);
        return result;
    }
    @GetMapping("token")
    public result token(@CookieValue("token") String token,HttpServletRequest request,HttpServletResponse response) throws Exception{
        Map map = redisTemplate.opsForHash().entries(token);
        if (map.isEmpty()) {
            CookieUtil.deleteCookie(token,request,response);
            result.fail("002", "账号过期,请重新登录");
            return result;
        }
        redisTemplate.expire(token, 60 * 60, TimeUnit.SECONDS); // 设置过期时间
        user user = BeanUtil.mapBean(map, user.class);
        user.setPassword(null);
        result.success("001", user);
        return result;
    }
}
