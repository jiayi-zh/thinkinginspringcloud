package com.bat.jyzh.business.beanvalidator.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 参数校验配置
 *
 * @author ZhengYu
 * @version 1.0 2021/3/9 11:48
 **/
@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                //false：普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
                //true：快速失败返回模式(只要有一个验证失败，则返回)
                .failFast(false)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
