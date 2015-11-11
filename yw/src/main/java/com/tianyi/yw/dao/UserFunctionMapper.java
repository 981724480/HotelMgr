package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.Function;
import com.tianyi.yw.model.UserFunction;
@MyBatisRepository
public interface UserFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFunction record);

    int insertSelective(UserFunction record);

    UserFunction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFunction record);

    int updateByPrimaryKey(UserFunction record);
    
    
    /////////////////
    List<UserFunction> getFunctionByUserId(Integer userId);

	void deleteByUserId(Integer id);

	List<UserFunction> getUserFunListByUserId(Integer id);
}