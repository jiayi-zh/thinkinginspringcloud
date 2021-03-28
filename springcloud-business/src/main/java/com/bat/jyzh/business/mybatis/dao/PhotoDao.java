package com.bat.jyzh.business.mybatis.dao;

import com.bat.jyzh.business.mybatis.entity.PhotoPO;

public interface PhotoDao {
    int deleteByPrimaryKey(Long id);

    int insert(PhotoPO record);

    int insertSelective(PhotoPO record);

    PhotoPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PhotoPO record);

    int updateByPrimaryKey(PhotoPO record);
}