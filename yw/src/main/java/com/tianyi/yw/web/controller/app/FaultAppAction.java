package com.tianyi.yw.web.controller.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.yw.common.JsonResult;
import com.tianyi.yw.model.CustomerCompany;
import com.tianyi.yw.web.controller.BaseAction;

@Scope("prototype")
@Controller
@RequestMapping("/app/fault")
public class FaultAppAction extends BaseAction {

	
	@ResponseBody
	@RequestMapping(value = "/list.do", produces = { "text/html;charset=UTF-8" })
	public JsonResult<CustomerCompany> list(HttpServletRequest request, HttpServletResponse response){
		JsonResult <CustomerCompany>js = new JsonResult<CustomerCompany>();
		js.setCode(new Integer(1));
		js.setMessage("查询失败!");
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return js;
	}
}
