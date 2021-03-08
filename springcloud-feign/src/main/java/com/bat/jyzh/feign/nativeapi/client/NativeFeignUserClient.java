package com.bat.jyzh.feign.nativeapi.client;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 使用Open Feign的注解
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 10:08
 **/
@Headers("Content-Type: application/json")
public interface NativeFeignUserClient {

    @RequestLine("GET /user/list")
    CommonResult<PageInfo<User>> queryUserList(@Param("name") String name);

    @RequestLine("POST /user")
    CommonResult<Long> postUser(User user);
}
