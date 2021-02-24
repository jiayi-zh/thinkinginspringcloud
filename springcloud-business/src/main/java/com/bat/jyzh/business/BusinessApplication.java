package com.bat.jyzh.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 业务服务启动主类
 *
 * @author ZhengYu
 * @version 1.0 2021/2/24 17:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
