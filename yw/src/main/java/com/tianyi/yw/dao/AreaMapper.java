package com.tianyi.yw.dao;

import com.tianyi.yw.model.Area;

/**
 * 维护区域接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}