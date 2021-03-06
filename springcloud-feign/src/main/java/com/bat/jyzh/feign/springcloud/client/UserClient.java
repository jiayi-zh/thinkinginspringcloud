package com.bat.jyzh.feign.springcloud.client;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务客户端
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 10:08
 **/
@FeignClient(name = "SPRINGCLOUD-BUSINESS")
@RequestMapping("/test")
public interface UserClient {

    @GetMapping("/user/list")
    CommonResult<PageInfo<User>> queryUserList(@RequestParam(value = "name") String name);

    @PostMapping("/user")
    CommonResult<Long> postUser(@RequestBody User user);
}
