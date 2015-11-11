package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.model.Project;
import com.tianyi.yw.model.ProjectPoint;

/**
 * 项目管理后台方法接口
 * @author liqiang
 *
 */
public interface ProjectService {

	List<Project> getProjectPageList(Project project);

	int getPorjectPageListCount(Project project);

	Project getPorjectById(Integer projectId);

	List<ProjectPoint> getProjectPointList(ProjectPoint projectPoint);

}
