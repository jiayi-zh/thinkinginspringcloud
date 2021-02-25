package com.bat.jyzh.business.idempotence;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现接口幂等
 *
 * @author ZhengYu
 * @version 1.0 2021/2/25 17:11
 **/
@RestController
public class IdempotenceController {

    @GetMapping("/idempotence/test1")
    public String test1() {
        return "idempotence test1";
    }
}
