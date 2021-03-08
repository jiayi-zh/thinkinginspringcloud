package com.bat.jyzh.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

/**
 * Feign 应用
 *
 * @author ZhengYu
 * @version 1.0 2021/3/4 19:52
 **/
@SpringBootApplication(scanBasePackages = "com.bat.jyzh.feign", scanBasePackageClasses = FeignClientsConfiguration.class)
@EnableFeignClients(basePackages = "com.bat.jyzh.feign.springcloud.client")
@EnableDiscoveryClient
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}