package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.CustomerUser;

/**
 * 客户联系人接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface CustomerUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerUser record);

    int insertSelective(CustomerUser record);

    CustomerUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerUser record);

    int updateByPrimaryKey(CustomerUser record);

	List<CustomerUser> getCustomerUserPageList(CustomerUser user);

	int getCustomerUserPageListCount(CustomerUser user);
}