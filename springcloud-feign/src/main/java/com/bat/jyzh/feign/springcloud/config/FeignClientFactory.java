package com.bat.jyzh.feign.springcloud.config;

import com.bat.jyzh.feign.springcloud.client.UserClient;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Feign 配置类
 *
 * @author ZhengYu
 * @version 1.0 2021/3/8 13:19
 **/
@Component
public class FeignClientFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public UserClient buildUserClient(String addr) {
        final Contract contract = applicationContext.getBean(Contract.class);
        final Decoder decoder = applicationContext.getBean(Decoder.class);
        final Encoder encoder = applicationContext.getBean(Encoder.class);

        return Feign.builder()
                .contract(contract)
                .decoder(decoder)
                .encoder(encoder)
                .client(new OkHttpClient())
                .target(UserClient.class, addr);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
