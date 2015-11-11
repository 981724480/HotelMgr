package com.tianyi.yw.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.yw.model.BaseConfig;
import com.tianyi.yw.service.BaseConfigService;
import com.tianyi.yw.service.UserService;

@Scope("prototype")
@Controller
@RequestMapping("/web/loadcommon")
public class LoadCommonAction extends BaseAction {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "baseConfigService")
	private BaseConfigService baseConfigService;
	
	
	/**
	 * 加载类型信息
	 * 
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonLoadBaseConfig.do")
	public List<BaseConfig> QueryBaseConfig(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="typeId",required=true)Integer typeId,
			@RequestParam(value="parentId",required=false)Integer parentId) {
		return baseConfigService.getBaseConfigByWhere(typeId, parentId);
	}
	
	
}
