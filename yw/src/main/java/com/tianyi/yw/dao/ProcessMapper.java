package com.tianyi.yw.dao;

import com.tianyi.yw.model.Process;

@MyBatisRepository
public interface ProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);
}