package com.bat.jyzh.feign.nativeapi.client;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 用户服务客户端
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 10:08
 **/
@Headers("Content-Type: application/json")
public interface UserClient {

    @RequestLine("GET /user/list")
    CommonResult<PageInfo<User>> queryUserList(@Param("name") String name);

    @RequestLine("POST /user")
    CommonResult<Long> postUser(User user);
}
