package com.tianyi.yw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.dao.CompanyMapper;
import com.tianyi.yw.dao.UserMapper;
import com.tianyi.yw.model.Company;
import com.tianyi.yw.service.CompanyService;

/**
 * 员工公司管理后台接口方法实现
 * 
 * @author liqiang
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public List<Company> getUserCompanyPageList(Company company) {
		// TODO Auto-generated method stub
		return companyMapper.getUserCompanyPageList(company);
	}

	@Override
	public int getUserCompanyPageListCount(Company company) {
		// TODO Auto-generated method stub
		return companyMapper.getUserCompanyPageListCount(company);
	}

	@Override
	public void saveUserCompany(Company company) {
		// TODO Auto-generated method stub
		if (company.getId() == 0) {
			company.setUserNum(0);
			companyMapper.insert(company);
		} else {
			companyMapper.updateByPrimaryKey(company);
		}
	}

	@Override
	public Company getCompanyById(Integer companyId) {
		// TODO Auto-generated method stub
		return companyMapper.selectByPrimaryKey(companyId);
	}

}
