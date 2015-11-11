package com.tianyi.yw.dao;

import com.tianyi.yw.model.ProjectArea;

/**
 * 项目区域关系你接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface ProjectAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectArea record);

    int insertSelective(ProjectArea record);

    ProjectArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectArea record);

    int updateByPrimaryKey(ProjectArea record);
}