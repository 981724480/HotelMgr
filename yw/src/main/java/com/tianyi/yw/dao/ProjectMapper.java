package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.Project;

/**
 * 项目接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

	List<Project> getProjectPageList(Project project);

	int getPorjectPageListCount(Project project);
}