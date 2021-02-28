package com.bat.jyzh.business.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Mybatis 测试
 *
 * @author ZhengYu
 * @version 1.0 2021/2/26 21:49
 **/
@Slf4j
@RestController
public class MybatisController {

    private static final Random RANDOM = new Random();

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
