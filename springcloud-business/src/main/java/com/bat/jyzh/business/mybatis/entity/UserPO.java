package com.bat.jyzh.business.mybatis.entity;

import lombok.Data;

/**
 * UserPO
 *
 * @author ZhengYu
 * @version 1.0 2021/3/13 13:42
 **/
@Data
public class UserPO {

    private Long id;

    private String name;

    // TODO 映射成枚举
    private Byte sex;

    private String birthday;

    private String address;
}
