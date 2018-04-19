package com.zxh.o2o.dao;

import com.zxh.o2o.entity.HeadLine;

public interface HeadLineMapper {
    int deleteByPrimaryKey(Integer lineId);

    int insert(HeadLine record);

    int insertSelective(HeadLine record);

    HeadLine selectByPrimaryKey(Integer lineId);

    int updateByPrimaryKeySelective(HeadLine record);

    int updateByPrimaryKey(HeadLine record);
}