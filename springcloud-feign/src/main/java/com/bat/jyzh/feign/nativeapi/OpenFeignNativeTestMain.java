package com.bat.jyzh.feign.nativeapi;

import com.alibaba.fastjson.JSONObject;
import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import com.bat.jyzh.feign.nativeapi.client.UserClient;
import com.bat.jyzh.feign.nativeapi.decoder.CustomDecoder;
import com.bat.jyzh.feign.nativeapi.encoder.CustomEncoder;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * 原生 OpenFeign 使用
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 9:13
 **/
@Slf4j
public class OpenFeignNativeTestMain {
    public static void main(String[] args) {
        UserClient userClient = Feign.builder()
                .decoder(new CustomDecoder())
                .encoder(new CustomEncoder())
                .client(new OkHttpClient())
                .target(UserClient.class, "http://127.0.0.1:11011/test");

        CommonResult<Long> postUserResp = userClient.postUser(new User("zy", 27));
        log.info("post user ==> {}", postUserResp);
        CommonResult<PageInfo<User>> userListResp = userClient.queryUserList("zy");
        log.info("query user list ==> {}", JSONObject.toJSONString(userListResp));
    }
}
