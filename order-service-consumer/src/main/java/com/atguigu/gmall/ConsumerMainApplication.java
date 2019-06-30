package com.atguigu.gmall;

import com.atguigu.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMainApplication {

//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
//        context.start();
//        UserService userService = (UserService)context.getBean("userService"); // 获取远程服务代理
//        List<UserAddress> addressList = userService.getUserAddressList("1");// 执行远程方法
//        System.out.println( addressList ); // 显示调用结果
//    }

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = context.getBean(OrderService.class);
        orderService.initOrder("1");

        System.in.read();
    }

}
