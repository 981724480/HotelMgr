package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.CustomerCompany;
import com.tianyi.yw.model.User;

/**
 * 客户公司接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface CustomerCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerCompany record);

    int insertSelective(CustomerCompany record);

    CustomerCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerCompany record);

    int updateByPrimaryKey(CustomerCompany record);
    
/////
    List<CustomerCompany> getCustomerCompanyPageList(CustomerCompany example);
    
    int getCustomerCompanyPageListCount(CustomerCompany example);

}