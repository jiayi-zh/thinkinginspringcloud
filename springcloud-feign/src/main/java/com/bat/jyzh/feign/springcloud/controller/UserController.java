package com.bat.jyzh.feign.springcloud.controller;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import com.bat.jyzh.feign.springcloud.client.UserClient;
import com.bat.jyzh.feign.springcloud.config.FeignClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @author ZhengYu
 * @version 1.0 2021/3/7 16:49
 **/
@RestController
@RequestMapping("/test")
public class UserController {

    /**
     * Feign Client Spring 提供的使用方式
     */
    @Autowired
    private UserClient userClient;

    @GetMapping("/feign")
    public CommonResult<PageInfo<User>> feignQueryUserList(@RequestParam(value = "name", required = false) String name) {
        userClient.postUser(new User("jiayi-zh", 27));
        return userClient.queryUserList(name);
    }

    /**
     * 动态指定服务地址
     */
    @Autowired
    private FeignClientFactory feignClientFactory;

    @GetMapping("/feign/custom")
    public CommonResult<PageInfo<User>> customQueryUserList(@RequestParam(value = "name", required = false) String name) {
        final UserClient userClient = feignClientFactory.buildUserClient("http://127.0.0.1:11011");
        userClient.postUser(new User("jiayi-zh", 27));
        return userClient.queryUserList(name);
    }
}
