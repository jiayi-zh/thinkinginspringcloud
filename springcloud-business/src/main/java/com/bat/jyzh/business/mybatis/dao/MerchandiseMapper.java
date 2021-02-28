package com.bat.jyzh.business.mybatis.dao;

import com.bat.jyzh.business.mybatis.entity.Merchandise;

public interface MerchandiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Merchandise record);

    int insertSelective(Merchandise record);

    Merchandise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Merchandise record);

    int updateByPrimaryKey(Merchandise record);
}