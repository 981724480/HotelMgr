package com.tianyi.yw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.dao.CustomerCompanyMapper;
import com.tianyi.yw.dao.CustomerUserMapper;
import com.tianyi.yw.model.CustomerCompany;
import com.tianyi.yw.model.CustomerUser;
import com.tianyi.yw.service.CustomerService;


/**
* 客户管理后台接口方法实现
* @author liqiang
*
*/
@Service("customerService")
public class CustomerServiceImpl  implements CustomerService {

	@Resource
	private CustomerCompanyMapper customerCompanyMapper;
	@Resource
	private CustomerUserMapper customerUserMapper;
	
	
	//[start] 客户公司模块
	@Override
	public int deleteCustomerCompany(Integer id) {
		// TODO Auto-generated method stub
		return customerCompanyMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int saveCustomerCompany(CustomerCompany record) {
		// TODO Auto-generated method stub
		return customerCompanyMapper.insertSelective(record);
	}
	@Override
	public int updateCustomerCompany(CustomerCompany record) {
		// TODO Auto-generated method stub
		return customerCompanyMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<CustomerCompany> getCustomerCompanyPageList(CustomerCompany example) {
		// TODO Auto-generated method stub
		return customerCompanyMapper.getCustomerCompanyPageList(example);
	}
	@Override
	public int getCustomerCompanyPageListCount(CustomerCompany example) {
		// TODO Auto-generated method stub
		return customerCompanyMapper.getCustomerCompanyPageListCount(example);
	}
	@Override
	public CustomerCompany getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerCompanyMapper.selectByPrimaryKey(customerId);
	}
	
	
	//[end]
	
	//[start] 客户联系人模块

	@Override
	public List<CustomerUser> getCustomerUserPageList(CustomerUser user) {
		// TODO Auto-generated method stub
		return customerUserMapper.getCustomerUserPageList(user);
	}
	@Override
	public int getCustomerUserPageListCount(CustomerUser user) {
		// TODO Auto-generated method stub
		return customerUserMapper.getCustomerUserPageListCount(user);
	}
	@Override
	public void saveCustomerUser(CustomerUser user) {
		// TODO Auto-generated method stub
		if(user.getId()>0){
			customerUserMapper.updateByPrimaryKey(user);
		}else{
			customerUserMapper.insert(user);
		}
	}
	@Override
	public CustomerUser getCustomerUserByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return customerUserMapper.selectByPrimaryKey(userId);
	}
	
	//[end]
}
