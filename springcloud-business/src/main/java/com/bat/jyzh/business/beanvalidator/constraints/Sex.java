package com.bat.jyzh.business.beanvalidator.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义性别校验
 *
 * @author ZhengYu
 * @version 1.0 2021/3/9 12:35
 **/
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomSexValidator.class)
public @interface Sex {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
