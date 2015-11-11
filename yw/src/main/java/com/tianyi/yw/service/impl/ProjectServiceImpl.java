package com.tianyi.yw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.dao.ProjectMapper;
import com.tianyi.yw.dao.ProjectPointMapper;
import com.tianyi.yw.model.Project;
import com.tianyi.yw.model.ProjectPoint;
import com.tianyi.yw.service.ProjectService;
 
/**
 * 项目后台接口方法实现
 * @author liqiang
 *
 */
@Service("projectService")
public class ProjectServiceImpl  implements ProjectService{
	@Resource
	private ProjectMapper projectMapper;
	@Resource
	private ProjectPointMapper projectPointMapper;
	
	//[start] 项目主体模块

	@Override
	public List<Project> getProjectPageList(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.getProjectPageList(project);
	}

	@Override
	public int getPorjectPageListCount(Project project) {
		// TODO Auto-generated method stub
		return  projectMapper.getPorjectPageListCount(project);
	} 

	@Override
	public Project getPorjectById(Integer projectId) {
		// TODO Auto-generated method stub
		return projectMapper.selectByPrimaryKey(projectId);
	}
	//[end]	
	
	//[start] 项目区域模块
	
	//[end]
	
	//[start] 区域点位模块

	@Override
	public List<ProjectPoint> getProjectPointList(ProjectPoint projectPoint) {
		// TODO Auto-generated method stub
		return projectPointMapper.getProjectPointList(projectPoint);
	}
	//[end]
	
	//[start] 区域人员模块
	
	//[end]
}
