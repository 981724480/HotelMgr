package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.UserType;
@MyBatisRepository
public interface UserTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserType record);

    int insertSelective(UserType record);

    UserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserType record);

    int updateByPrimaryKey(UserType record);

	void deleteByUserId(Integer id);

	List<UserType> getUserTypeListByUserId(Integer id);
}