package com.bat.jyzh.gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * 路由配置
 *
 * @author ZhengYu
 * @version 1.0 2021/2/25 17:34
 **/
@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder rlb) {
        return rlb.routes().
                route("springcloud-business", new Function<PredicateSpec, Buildable<Route>>() {
                    @Override
                    public Buildable<Route> apply(PredicateSpec predicateSpec) {
                        return predicateSpec.path("/business").uri("http://192.168.9.27");
                    }
                }).
                build();
    }
}
