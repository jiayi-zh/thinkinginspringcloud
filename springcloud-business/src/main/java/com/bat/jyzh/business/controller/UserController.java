package com.bat.jyzh.business.controller;

import com.bat.jyzh.common.entity.User;
import com.bat.jyzh.common.entity.resp.CommonResult;
import com.bat.jyzh.common.entity.resp.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Get POST 服务提供
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 9:16
 **/
@RestController
@RequestMapping("/test")
public class UserController {


    private static final List<User> simulatedDB = new CopyOnWriteArrayList<>();

    private static final AtomicLong idGenerator = new AtomicLong();

    @GetMapping("/user/list")
    public CommonResult<PageInfo<User>> queryUserList(@RequestParam(value = "name", required = false) String name) {
        List<User> userList;
        if (StringUtils.isEmpty(name)) {
            userList = simulatedDB;
        } else {
            userList = simulatedDB.stream().filter(user -> user.getName().contains(name)).collect(Collectors.toList());
        }
        return new CommonResult<>(0, "success", new PageInfo<>((long) userList.size(), userList));
    }

    @PostMapping("/user")
    public CommonResult<Long> postUser(@RequestBody User user) {
        if (user.getId() == null) {
            user.setId(idGenerator.getAndIncrement());
        }
        simulatedDB.add(user);
        return new CommonResult<>(0, "success", user.getId());
    }
}
