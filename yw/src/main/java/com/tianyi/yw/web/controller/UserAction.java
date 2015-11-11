package com.tianyi.yw.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.yw.common.JsonResult;
import com.tianyi.yw.common.utils.Constants;
import com.tianyi.yw.common.utils.EndecryptUtils;
import com.tianyi.yw.model.Company;
import com.tianyi.yw.model.User;
import com.tianyi.yw.model.UserFunction;
import com.tianyi.yw.model.UserType;
import com.tianyi.yw.service.CompanyService;
import com.tianyi.yw.service.UserService;

@Scope("prototype")
@Controller
@RequestMapping("/web/user")
public class UserAction extends BaseAction {

	// [start] 接口引用
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "companyService")
	private CompanyService companyService;

	// [end]

	// [start] 员工公司模块 ---- 页面跳转

	/**
	 * 页面跳转到员工管理页面，加载员工所属公司列表
	 * 
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/companyList.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String logInit(Company company, HttpServletRequest request,
			HttpServletResponse response) {
		if (company.getPageNo() == null)
			company.setPageNo(1);
		company.setPageSize(Constants.DEFAULT_PAGE_SIZE);

		List<Company> lc = companyService.getUserCompanyPageList(company);
		int totalCount = companyService.getUserCompanyPageListCount(company);
		company.setTotalCount(totalCount);
		request.setAttribute("userCompany", company);
		request.setAttribute("userCompanylist", lc);
		return "web/user/companyList";
	}
	/**
	 * 页面跳转到员工列表，加载员工所属公司列表
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userList.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String logInituser(User user, 
			@RequestParam(value = "companyId", required = false) Integer companyId,
			HttpServletRequest request,
			HttpServletResponse response) {
		if (user.getPageNo() == null)
			user.setPageNo(1);
		user.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		user.setCompanyId(companyId); 
		Company company = companyService.getCompanyById(companyId);
		List<User> lc = userService.getUserPageList(user);
		int totalCount = userService.getUserPageListCount(user);
		user.setTotalCount(totalCount);
		request.setAttribute("company", company);
		request.setAttribute("user", user);
		request.setAttribute("userlist", lc);
		return "web/user/userList";
	}
	
	/**
	 * 页面跳转到员工管理页面，加载员工所属公司列表
	 * 
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/companyinfo.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String gotoCompanyInfo( 
			@RequestParam(value = "companyId", required = false) Integer companyId,
			HttpServletRequest request, HttpServletResponse response) {
		Company company = companyService.getCompanyById(companyId);  
		request.setAttribute("company", company);  
		return "web/user/companyInfo";
	}


	/**
	 * 页面跳转到员工编辑，加载员工信息
	 * 
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userinfo.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String gotoUserInfo(
			User user,
			@RequestParam(value = "userId", required = false) Integer userId,
			HttpServletRequest request, HttpServletResponse response) {
		if(user.getId()!=null){
			userId = user.getId();
		}
		user = userService.getUserByPrimaryKey(userId);  
		
		List<UserFunction> uf = new ArrayList<UserFunction>();
		List<UserType> ut = new ArrayList<UserType>();
		uf = userService.getUserFunListByUserId(userId);
		List<Integer> userFun = new ArrayList<Integer>();
		List<Integer> userType = new ArrayList<Integer>();
		for(UserFunction f :uf){
			userFun.add(f.getFunctionId());
		}
		ut = userService.getUserTypeListByUserId(userId); 
		for(UserType t :ut){
			userType.add(Integer.parseInt(t.getMaintainanceKey()));
		}
		user.setUserFunList(userFun);
		user.setUserTypeList(userType);
		request.setAttribute("userinfo", user);  
		return "web/user/userInfo";
	}

	
	// [end]

	// [start] 员工公司模块 ---- 逻辑处理

	/**
	 * 新增或编辑员工公司信息
	 * 
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOrupdateCompany.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JsonResult saveOrupdateCompany(Company company,
			HttpServletRequest request, HttpServletResponse response) {
		JsonResult js = new JsonResult();
		js.setCode(new Integer(1));
		js.setMessage("保存失败!");
		try {
			if (company.getId() == null || company.getId() == 0) {
				company.setId(0);
			}
			company.setFlag(0);
			company.setCreateUser(this.getLoginUser().getId());
			company.setCreatetTime(new Date());
			companyService.saveUserCompany(company);
			js.setCode(new Integer(0));
			js.setMessage("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return js;
	}

	@ResponseBody
	@RequestMapping(value = "/saveOrupdateUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JsonResult saveOrupdateUser(User user, HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult js = new JsonResult();
		js.setCode(new Integer(1));
		js.setMessage("保存失败!");
		try { 
			user.setFlag(0);
			if(user.getPhone()!=null){
				user.setAccount(user.getPhone());
			}
			User u = EndecryptUtils.md5Password(user.getAccount(), "111111");
			if(u!=null){
				user.setPassword(u.getPassword());
				user.setSalt(u.getSalt());
			}
			user.setCreateUser(this.getLoginUser().getId());
			user.setCreateTime(new Date());
			userService.SaveorUpdateUser(user);
			js.setCode(new Integer(0));
			js.setMessage("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return js;
	}

	// [end]

}
