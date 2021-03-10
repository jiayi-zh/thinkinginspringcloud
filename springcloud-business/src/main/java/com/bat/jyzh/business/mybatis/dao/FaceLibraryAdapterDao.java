package com.bat.jyzh.business.mybatis.dao;

import com.bat.jyzh.business.mybatis.entity.FaceLibraryAdapterPO;

public interface FaceLibraryAdapterDao {

    int deleteByPrimaryKey(Long id);

    int insert(FaceLibraryAdapterPO record);

    int insertSelective(FaceLibraryAdapterPO record);

    FaceLibraryAdapterPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FaceLibraryAdapterPO record);

    int updateByPrimaryKey(FaceLibraryAdapterPO record);
}