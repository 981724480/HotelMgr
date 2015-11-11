package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.model.CustomerCompany;
import com.tianyi.yw.model.CustomerUser;
import com.tianyi.yw.model.User;

/**
 * 客户管理后台方法接口
 * @author liqiang
 *
 */
public interface CustomerService {

	 	int deleteCustomerCompany(Integer id);

	    int saveCustomerCompany(CustomerCompany record);
	    
	    int updateCustomerCompany(CustomerCompany record);
	    
	    
	    /////
	    List<CustomerCompany> getCustomerCompanyPageList(CustomerCompany example);
	    
	    int getCustomerCompanyPageListCount(CustomerCompany example);

		CustomerCompany getCustomerById(Integer customerId);

		List<CustomerUser> getCustomerUserPageList(CustomerUser user);

		int getCustomerUserPageListCount(CustomerUser user);

		void saveCustomerUser(CustomerUser user);

		CustomerUser getCustomerUserByPrimaryKey(Integer userId);

}
