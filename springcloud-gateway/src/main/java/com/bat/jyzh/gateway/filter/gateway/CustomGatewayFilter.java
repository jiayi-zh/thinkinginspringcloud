package com.bat.jyzh.gateway.filter.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义 {@link org.springframework.cloud.gateway.filter.GatewayFilter}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/26 10:07
 **/
@Slf4j
public class CustomGatewayFilter implements GatewayFilter, Ordered {

    private static final String START_TIME_KEY = "gateway_start_time_key";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(START_TIME_KEY, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.<Long>getAttribute(START_TIME_KEY);
            if (startTime != null) {
                log.info("{} cost : {} ms", exchange.getRequest().getURI().getRawPath(), System.currentTimeMillis() - startTime);
            }
        }));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
