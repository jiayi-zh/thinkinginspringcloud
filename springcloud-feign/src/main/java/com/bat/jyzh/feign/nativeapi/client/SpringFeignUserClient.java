package com.bat.jyzh.feign.nativeapi.client;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务客户端
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 10:08
 **/
@RequestMapping("/test")
public interface SpringFeignUserClient {

    @GetMapping(value = "/user/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    CommonResult<PageInfo<User>> queryUserList(@RequestParam(value = "name") String name);

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    CommonResult<Long> postUser(@RequestBody User user);
}
