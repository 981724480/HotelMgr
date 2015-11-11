package com.tianyi.yw.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tianyi.yw.common.utils.Constants;
import com.tianyi.yw.model.Project;
import com.tianyi.yw.model.ProjectPoint;
import com.tianyi.yw.service.ProjectService;

@Scope("prototype")
@Controller
@RequestMapping("/web/project")
public class ProjectAction  extends BaseAction  {
	

	// [start] 接口引用
	@Resource(name = "projectService")
	private ProjectService projectService;

	// [end]

	
	
	// [start] 项目管理模块，页面跳转
	/**
	 * 项目列表页面跳转
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectList.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String logInit(Project project, HttpServletRequest request,
			HttpServletResponse response) {
		if (project.getPageNo() == null)
			project.setPageNo(1);
		project.setPageSize(Constants.DEFAULT_PAGE_SIZE);

		List<Project> lc = projectService.getProjectPageList(project);
		int totalCount = projectService.getPorjectPageListCount(project);
		project.setTotalCount(totalCount);
		request.setAttribute("project", project);
		request.setAttribute("projectlist", lc);
		return "web/project/projectInfoList";
	}

	/**
	 * 项目列表页面跳转
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectInfo.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String logIniti(
			ProjectPoint projectPoint,
			@RequestParam(value = "projectId", required = false) Integer projectId,
			HttpServletRequest request,
			HttpServletResponse response) {
		//if (projectPoint.getPageNo() == null)
		//	projectPoint.setPageNo(1);
		//projectPoint.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		Project project = new Project();
		if(projectId == 0){
			project.setId(0);
		}else{
			project = projectService.getPorjectById(projectId);
		}
		projectPoint.setProjectId(project.getId());
		List<ProjectPoint> lc = projectService.getProjectPointList(projectPoint);
		//int totalCount = projectService.getPorjectPointPageListCount(projectPoint);
		//projectPoint.setTotalCount(totalCount);
		request.setAttribute("pointlist", lc);
		request.setAttribute("project", project);
		return "web/project/projectInfo";
	}
	
	//[end]
}
