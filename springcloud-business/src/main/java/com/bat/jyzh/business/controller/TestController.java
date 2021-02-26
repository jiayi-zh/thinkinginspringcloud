package com.bat.jyzh.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 * @author ZhengYu
 * @version 1.0 2021/2/26 9:47
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
}
