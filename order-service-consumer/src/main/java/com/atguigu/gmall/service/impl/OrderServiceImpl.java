package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        addressList.stream()
                .map(UserAddress::getUserAddress)
                .forEach(System.out::println);
        return addressList;
    }
}
