package com.bat.jyzh.feign.nativeapi;

import com.alibaba.fastjson.JSONObject;
import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import com.bat.jyzh.feign.nativeapi.client.NativeFeignUserClient;
import com.bat.jyzh.feign.nativeapi.client.SpringFeignUserClient;
import com.bat.jyzh.feign.nativeapi.decoder.CustomDecoder;
import com.bat.jyzh.feign.nativeapi.encoder.CustomEncoder;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

/**
 * 原生 OpenFeign 使用
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 9:13
 **/
@Slf4j
public class OpenFeignNativeTestMain {
    public static void main(String[] args) {
        springOpenFeignClientTest();
    }

    /**
     * 原生的Open Feign使用方式
     *
     * @author ZhengYu
     */
    private static void nativeOpenFeignClientTest() {
        NativeFeignUserClient nativeFeignUserClient = Feign.builder()
                .decoder(new CustomDecoder())
                .encoder(new CustomEncoder())
                .client(new OkHttpClient())
                .target(NativeFeignUserClient.class, "http://127.0.0.1:11011/test");

        CommonResult<Long> postUserResp = nativeFeignUserClient.postUser(new User("zy", 27));
        log.info("post user ==> {}", postUserResp);
        CommonResult<PageInfo<User>> userListResp = nativeFeignUserClient.queryUserList("zy");
        log.info("query user list ==> {}", JSONObject.toJSONString(userListResp));
    }


    /**
     * Spring MVC结合的Open Feign使用方式
     *
     * @author ZhengYu
     */
    private static void springOpenFeignClientTest() {
        SpringFeignUserClient springFeignUserClient = Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new CustomDecoder())
                .encoder(new CustomEncoder())
                .client(new OkHttpClient())
                .target(SpringFeignUserClient.class, "http://127.0.0.1:11011");

        CommonResult<Long> postUserResp = springFeignUserClient.postUser(new User("zy", 27));
        log.info("post user ==> {}", postUserResp);
        CommonResult<PageInfo<User>> userListResp = springFeignUserClient.queryUserList("zy");
        log.info("query user list ==> {}", JSONObject.toJSONString(userListResp));
    }
}
