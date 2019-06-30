package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("version 1.0.0");
        UserAddress address1 = new UserAddress(1, "福州外语外贸学院", "1", "陈凯霖", "110", "YES");
        UserAddress address2 = new UserAddress(2, "晋江", "1", "陈凯霖", "110", "NO");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(address1, address2);
    }
}
