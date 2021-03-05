package com.bat.jyzh.common.entity;

import lombok.Data;

/**
 * 用户类
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 9:18
 **/
@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
