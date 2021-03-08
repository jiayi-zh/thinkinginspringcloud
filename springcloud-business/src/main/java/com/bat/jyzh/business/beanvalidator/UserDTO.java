package com.bat.jyzh.business.beanvalidator;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Bean Validator
 *
 * @author ZhengYu
 * @version 1.0 2021/3/8 19:35
 **/
@Data
public class UserDTO {

    @NotBlank(message = "姓名不能为空")
    @Length(max = 3, message = "长度超过限制")
    private String userName;

    @NotNull(message = "手机号不能为空")
    private String mobileNo;

    private Integer sex;

    private Integer age;

    @Email(message = "邮件格式不符")
    private String email;

    @Valid
    @NotNull
    private CityDTO cityDTO;

    private List<String> hobbies;
}

