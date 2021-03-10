package com.bat.jyzh.business.mybatis.dao;

import com.bat.jyzh.business.mybatis.entity.FaceAdapterPO;

public interface FaceAdapterDao {

    int deleteByPrimaryKey(Long id);

    int insert(FaceAdapterPO record);

    int insertSelective(FaceAdapterPO record);

    FaceAdapterPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FaceAdapterPO record);

    int updateByPrimaryKey(FaceAdapterPO record);
}