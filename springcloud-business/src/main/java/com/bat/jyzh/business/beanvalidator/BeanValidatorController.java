package com.bat.jyzh.business.beanvalidator;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bean Validator 参数校验测试
 *
 * @author ZhengYu
 * @version 1.0 2021/3/8 19:31
 **/
@Slf4j
@RestController
@RequestMapping("/bean/validator")
public class BeanValidatorController {

    @PostMapping("/test")
    public String test(@RequestBody @Validated UserDTO userDTO) {
        log.info("{}", JSONObject.toJSONString(userDTO));
        return "success";
    }
}
