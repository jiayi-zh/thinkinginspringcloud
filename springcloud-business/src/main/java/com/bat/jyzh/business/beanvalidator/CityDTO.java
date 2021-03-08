package com.bat.jyzh.business.beanvalidator;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Bean Validator
 *
 * @author ZhengYu
 * @version 1.0 2021/3/8 19:40
 **/
@Data
public class CityDTO {

    @NotBlank(message = "城市不能为空")
    private String name;
}
