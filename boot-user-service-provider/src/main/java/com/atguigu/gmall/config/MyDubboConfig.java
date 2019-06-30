package com.atguigu.gmall.config;

import com.alibaba.dubbo.config.*;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class MyDubboConfig {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    //  <dubbo:registry address="zookeeper://127.0.0.1:2181"/>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    //  <dubbo:protocol name="dubbo" port="20880"/>
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);
        return protocolConfig;
    }

    //   <dubbo:service interface="com.atguigu.gmall.service.UserService" ref="userServiceImpl" version="1.0.0" timeout="4000"/>
    @Bean
    public ServiceConfig serviceConfig(UserServiceImpl ref) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();

        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(ref);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.setTimeout(4000);

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        //将method的设置保存到service中
        serviceConfig.setMethods(Collections.singletonList(methodConfig));

        return serviceConfig;
    }

    //   <dubbo:monitor address="127.0.0.1:7070"/>
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setAddress("127.0.0.1:7070");
        return monitorConfig;
    }

}
