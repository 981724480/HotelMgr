package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.ProjectPoint;

/**
 * 点位接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface ProjectPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPoint record);

    int insertSelective(ProjectPoint record);

    ProjectPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectPoint record);

    int updateByPrimaryKey(ProjectPoint record);

	List<ProjectPoint> getProjectPointList(ProjectPoint projectPoint);
}