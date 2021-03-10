package com.bat.jyzh.business;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
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
@MapperScans({
        // 当多个 @MapperScan 扫描到相同的 dao 时, 先扫描的 SqlSessionTemplate 持有该 Dao 的代理对象
        @MapperScan(basePackages = "com.bat.jyzh.business.mybatis.dao", sqlSessionTemplateRef = "faceAlgorithmAdapterSqlSessionTemplate"),
        @MapperScan(basePackages = "com.bat.jyzh.business.mybatis.dao", sqlSessionTemplateRef = "cloudAlgorithmAdapterSqlSessionTemplate"),
})
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
