package com.tianyi.yw.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.yw.common.JsonResult;
import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.common.utils.Constants;
import com.tianyi.yw.model.CustomerCompany;
import com.tianyi.yw.model.Function;
import com.tianyi.yw.model.User;
import com.tianyi.yw.service.FunctionService;
import com.tianyi.yw.service.UserService;

@Scope("prototype")
@Controller
public class LoginAction extends BaseAction {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="functionService")
	private FunctionService functionService;
	
	@ResponseBody
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public JsonResult <User> login(User user, HttpServletRequest request, HttpServletResponse response){
		JsonResult <User>json  = new JsonResult<User>();
		json.setCode(new Integer(1));
		json.setMessage("登录失败!");
		try{
			ReturnResult<User> res = userService.login(user.getAccount(), user.getPassword(),user.isRememberMe());
			if(res.getCode() == ReturnResult.SUCCESS){
				List<Function>lf = parseFunctionList(functionService.getFunctionByUserId(res.getResultObject().getId()));
				request.getSession().setAttribute(Constants.USER_SESSION_FUNCTION,lf);
				
				
				res.getResultObject().setSelectedMainMemu(lf.get(0).getId());
				res.getResultObject().setSelectedChildMenu(lf.get(0).getChildFunctionlist().get(0).getId());
				res.getResultObject().setChildMenuList(lf.get(0).getChildFunctionlist());
				this.setLoginUser(res.getResultObject());
				
				json.setCode(new Integer(0));
//				json.setGotoUrl(lf.get(0).getUrl());
//				json.setGotoUrl("web/user/userinfo.do");
				//模块拆分
				json.setGotoUrl("web/user/companyList.do");
				json.setMessage("登录成功!");
			}else{				
				json.setMessage(res.getMessage());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	
	private List<Function> parseFunctionList(List<Function> src){
		for(Function f : src){
			f.setChildFunctionlist(functionService.getFunctionByParentId(f.getId()));
		}
		return src;
	}
	
} 
