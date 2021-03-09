package com.bat.jyzh.business.beanvalidator.constraints;


import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * {@link Sex} 的校验逻辑
 *
 * @author ZhengYu
 * @version 1.0 2021/3/9 12:38
 **/
public class CustomSexValidator implements ConstraintValidator<Sex, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        return "male".equals(value) || "female".equals(value);
    }
}
