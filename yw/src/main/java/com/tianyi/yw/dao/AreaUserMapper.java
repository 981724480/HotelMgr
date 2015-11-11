package com.tianyi.yw.dao;

import com.tianyi.yw.model.AreaUser;

/**
 * 维护区域分配人员接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface AreaUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AreaUser record);

    int insertSelective(AreaUser record);

    AreaUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AreaUser record);

    int updateByPrimaryKey(AreaUser record);
}