package com.bat.jyzh.business.mybatis.dao;

import com.bat.jyzh.business.mybatis.entity.UserPO;

/**
 * UserDao
 *
 * @author ZhengYu
 * @version 1.0 2021/3/13 13:44
 **/
public interface UserDao {

    int insert(UserPO user);
}
