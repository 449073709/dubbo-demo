package com.atguigu.gmall.stub;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;

import java.util.List;

public class UserServiceStub implements UserService {
    private final UserService userService;

    // 构造函数传入真正的远程代理对象
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("消费方自定义stub，检测userId是否为空或为空字符串");
        if (userId != null && userId.length() > 0) {
            return userService.getUserAddressList(userId);
        }
        return null;

    }
}