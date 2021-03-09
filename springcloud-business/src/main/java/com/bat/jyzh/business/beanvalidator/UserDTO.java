package com.bat.jyzh.business.beanvalidator;

import com.bat.jyzh.business.beanvalidator.constraints.Sex;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Bean Validator
 *
 * @author ZhengYu
 * @version 1.0 2021/3/8 19:35
 **/
@Data
public class UserDTO {
    /*
     * @Null 被注释的元素必须为 null
     * @NotNull 被注释的元素必须不为 null
     * @AssertTrue 被注释的元素必须为 true
     * @AssertFalse 被注释的元素必须为 false
     * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     * @Size(max=, min=) 被注释的元素的大小必须在指定的范围内
     * @Digits (integer, fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
     * @Past 被注释的元素必须是一个过去的日期
     * @Future 被注释的元素必须是一个将来的日期
     * @Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
     * Hibernate Validator 附加的 constraint
     * @NotBlank(message =) 验证字符串非null，且长度必须大于0
     * @Email 被注释的元素必须是电子邮箱地址
     * @Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
     * @NotEmpty 被注释的字符串必须非空
     * @Range(min=,max=,message=) 被注释的元素必须在合适的范围内
     */

    @NotBlank(message = "姓名不能为空")
    @Length(max = 3, message = "长度超过限制")
    private String userName;

    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$")
    private String mobileNo;

    @Sex(message = "性别取值不符合自定义规则")
    private String sex;

    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 150, message = "年龄不能大于150")
    private Integer age;

    @Email(message = "邮件格式不符")
    private String email;

    /**
     * 嵌套校验的使用场景 @Valid
     */
    @Valid
    @NotNull
    private CityDTO city;

    @Size(min = 1, max = 10, message = "爱好数量不合法")
    private List<String> hobbies;
}

