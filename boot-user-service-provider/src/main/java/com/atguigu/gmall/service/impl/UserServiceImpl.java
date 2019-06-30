package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> getUserAddressList(String userId) {
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        UserAddress address1 = new UserAddress(1, "福州外语外贸学院", "1", "陈凯霖", "110", "YES");
        UserAddress address2 = new UserAddress(2, "晋江", "1", "陈凯霖", "110", "NO");
        return Arrays.asList(address1, address2);
    }

    /**
     * initOrder 失败时的回调函数
     */
    public List<UserAddress> hello(String userId) {
        return Collections.singletonList(
                new UserAddress(0, "提供方出错", "提供方出错", "提供方出错", "提供方出错",
                        "提供方出错"));
    }

}
