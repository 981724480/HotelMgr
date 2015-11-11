package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.model.User;
import com.tianyi.yw.model.UserFunction;
import com.tianyi.yw.model.UserType;


public interface UserService {

    int deleteUser(Integer id);

    int saveUser(User record);
    
    int updateUser(User record);
    
    
    /////
    List<User> getUserPageList(User example);
    
    int getUserPageListCount(User example);

    ReturnResult<User> getUserById(Integer id);

    User getUserByName(String username);
    
	public ReturnResult<User> login(String loginName, String passwd,boolean rememberMe) throws Exception;

	void SaveorUpdateUser(User user);

	User getUserByPrimaryKey(Integer userId);

	List<UserFunction> getUserFunListByUserId(Integer userId);

	List<UserType> getUserTypeListByUserId(Integer userId);
	
}
