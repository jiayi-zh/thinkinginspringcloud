package com.bat.jyzh.business.mybatis.dao;

import com.bat.jyzh.business.mybatis.entity.UserPO;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}