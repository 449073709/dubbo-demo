package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(loadbalance = "roundrobin")
    UserService userService;

    @Override
    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String userId) {
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return userService.getUserAddressList(userId);
    }

    /**
     * initOrder 失败时的回调函数
     */
    public List<UserAddress> hello(String userId) {
        return Collections.singletonList(
                new UserAddress(0, "消费方出错", "消费方出错", "消费方出错", "消费方出错",
                        "消费方出错"));
    }

}
