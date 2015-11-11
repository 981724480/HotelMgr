package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.BaseConfig;
@MyBatisRepository
public interface BaseConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseConfig record);

    int insertSelective(BaseConfig record);

    BaseConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseConfig record);

    int updateByPrimaryKey(BaseConfig record);
    
    List<BaseConfig> getBaseConfigByWhere(BaseConfig record);
}