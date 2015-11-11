package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.Company;
@MyBatisRepository
public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

	List<Company> getUserCompanyPageList(Company company);

	int getUserCompanyPageListCount(Company company);
}