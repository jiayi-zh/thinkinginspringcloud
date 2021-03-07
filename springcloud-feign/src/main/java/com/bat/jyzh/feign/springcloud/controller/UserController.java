package com.bat.jyzh.feign.springcloud.controller;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import com.bat.jyzh.feign.springcloud.client.UserClient;
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

    @Autowired
    private UserClient userClient;

    @GetMapping("/feign")
    public CommonResult<PageInfo<User>> queryUserList(@RequestParam(value = "name", required = false) String name) {
        userClient.postUser(new User("jiayi-zh", 27));
        return userClient.queryUserList(name);
    }
}
