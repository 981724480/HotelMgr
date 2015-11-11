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
import com.tianyi.yw.model.CustomerCompany;
import com.tianyi.yw.model.CustomerUser;
import com.tianyi.yw.model.User;
import com.tianyi.yw.model.UserFunction;
import com.tianyi.yw.model.UserType;
import com.tianyi.yw.service.CustomerService;

/**
 * 客户管理逻辑控制器
 * 
 * @author xiaochenlin1
 * @update liqiang
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/web/customer")
public class CustomerAction extends BaseAction {

	// [start] 接口引用
	@Resource(name = "customerService")
	private CustomerService customerService;

	// [end]

	// [start] 客户管理页面跳转模块
	/**
	 * 客户列表
	 * 
	 * @param customerCompany
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/customerinfo.do")
	public String logInit(CustomerCompany customerCompany,
			HttpServletRequest request, HttpServletResponse response) {
		if (customerCompany.getPageNo() == null)
			customerCompany.setPageNo(1);
		customerCompany.setPageSize(Constants.DEFAULT_PAGE_SIZE);

		List<CustomerCompany> lc = customerService
				.getCustomerCompanyPageList(customerCompany);
		int totalCount = customerService
				.getCustomerCompanyPageListCount(customerCompany);
		customerCompany.setTotalCount(totalCount);
		request.setAttribute("customerCompany", customerCompany);
		request.setAttribute("customerCompanylist", lc);
		return "web/customer/customerInfoList";
	}
	/**
	 * 页面跳转到联系人列表，加载联系人
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/customerUserList.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String logInituser(CustomerUser user, 
			@RequestParam(value = "customerId", required = false) Integer customerId,
			HttpServletRequest request,
			HttpServletResponse response) {
		if (user.getPageNo() == null)
			user.setPageNo(1);
		user.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		user.setClientCompanyId(customerId); 
		CustomerCompany customer = customerService.getCustomerById(customerId);
		List<CustomerUser> lc = customerService.getCustomerUserPageList(user);
		int totalCount = customerService.getCustomerUserPageListCount(user);
		user.setTotalCount(totalCount);
		request.setAttribute("customer", customer);
		request.setAttribute("user", user);
		request.setAttribute("userlist", lc);
		return "web/customer/customerUserList";
	}

	/**
	 * 客户基本信息
	 * 
	 * @param customerCompany
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/customerdetail.do")
	public String logInit1(
			@RequestParam(value = "customerId", required = false) Integer customerId,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerCompany customer = customerService.getCustomerById(customerId);
		request.setAttribute("customer", customer);
		return "web/customer/customerInfo";
	}



	/**
	 * 页面跳转到员工编辑，加载员工信息
	 * 
	 * @param company
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/customeruserinfo.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String gotoUserInfo(
			CustomerUser user,
			@RequestParam(value = "userId", required = false) Integer userId,
			HttpServletRequest request, HttpServletResponse response) {
		if(user.getId()!=null){
			userId = user.getId();
		}
		user = customerService.getCustomerUserByPrimaryKey(userId);  
		request.setAttribute("customeruser", user);  
		return "web/customer/userInfo";
	}
	
	// [end]

	// [start] 客户管理模块逻辑

	/**
	 * 加载客户上级机构
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonLoadCustomerCompanyParent.do", produces = { "text/html;charset=UTF-8" })
	public JsonResult<CustomerCompany> loadCustomerCompanyParent(
			HttpServletRequest request, HttpServletResponse response) {
		JsonResult<CustomerCompany> js = new JsonResult<CustomerCompany>();
		js.setCode(new Integer(1));
		js.setMessage("查询失败!");
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return js;
	}

	/**
	 * 新增或保存客户资料
	 * 
	 * @param customerCompany
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonSaveOrupdateCompany.do", method = RequestMethod.POST, produces = { "text/html;charset=UTF-8" })
	public JsonResult<CustomerCompany> saveOrupdateCompany(
			CustomerCompany customerCompany, HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult<CustomerCompany> js = new JsonResult<CustomerCompany>();
		js.setCode(new Integer(1));
		js.setMessage("保存失败!");
		try {
			customerCompany.setFlag(0);
			customerCompany.setCreateUser(this.getLoginUser().getId());
			customerCompany.setCreatetTime(new Date());
			customerService.saveCustomerCompany(customerCompany);
			js.setCode(new Integer(0));
			js.setMessage("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return js;
	}
	
	/**
	 * 保存客户联系人信息
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOrupdateUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JsonResult<CustomerUser> saveOrupdateUser(CustomerUser user, HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult<CustomerUser> js = new JsonResult<CustomerUser>();
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
			customerService.saveCustomerUser(user);
			js.setCode(new Integer(0));
			js.setMessage("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return js;
	}

	// [end]
}
