package com.example.secondaryproject.controller;

import com.example.secondaryproject.service.Impl.OrderService;
import com.example.secondaryproject.vo.cartVo;
import com.example.secondaryproject.vo.orderVo;
import com.example.secondaryproject.vo.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private result result;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("")
    public result addOrder(@RequestBody List<cartVo> cartVoList, @CookieValue("token") String cookie){
        Integer userId = (Integer) redisTemplate.opsForHash().get(cookie, "userId");
        orderService.addOrder(cartVoList, userId);
        result.success("001", "下单成功");
        return result;
    }
    @GetMapping("")
    public result getOrder(@CookieValue("token") String cookie){
        Integer userId = (Integer) redisTemplate.opsForHash().get(cookie, "userId");
        List<orderVo> orderVoList = orderService.getOrder(userId);
        result.success("001",orderVoList);
        return result;
    }

}
