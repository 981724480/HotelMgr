package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.model.Company;

/**
 * 员工公司管理后台方法接口
 * @author liqiang
 *
 */
public interface CompanyService {

	List<Company> getUserCompanyPageList(Company company);

	int getUserCompanyPageListCount(Company company);

	void saveUserCompany(Company company);

	Company getCompanyById(Integer companyId);

}
