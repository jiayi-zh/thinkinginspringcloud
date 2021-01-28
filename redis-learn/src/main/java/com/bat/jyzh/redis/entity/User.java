package com.bat.jyzh.redis.entity;

import java.io.Serializable;

/**
 * User
 *
 * @author ZhengYu
 * @version 1.0 2021/1/27 14:21
 **/
public class User implements Serializable {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
