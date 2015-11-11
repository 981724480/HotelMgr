package com.tianyi.yw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.common.shiro.ShiroUsernamePasswordToken;
import com.tianyi.yw.dao.CompanyMapper;
import com.tianyi.yw.dao.UserFunctionMapper;
import com.tianyi.yw.dao.UserMapper;
import com.tianyi.yw.dao.UserTypeMapper;
import com.tianyi.yw.model.Company;
import com.tianyi.yw.model.User;
import com.tianyi.yw.model.UserFunction;
import com.tianyi.yw.model.UserType;
import com.tianyi.yw.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private UserFunctionMapper userFunctionMapper;
	@Resource
	private UserTypeMapper userTypeMapper;
	@Resource
	private CompanyMapper companyMapper;

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveUser(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	@Override
	public int updateUser(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<User> getUserPageList(User example) {
		// TODO Auto-generated method stub
		return userMapper.getUserPageList(example);
	}

	@Override
	public int getUserPageListCount(User example) {
		// TODO Auto-generated method stub
		return userMapper.getUserPageListCount(example);
	}

	@Override
	public ReturnResult<User> getUserById(Integer id) {
		// TODO Auto-generated method stub
		ReturnResult<User> rr = new ReturnResult<User>();
		rr.setResultObject(userMapper.selectByPrimaryKey(id));
		return rr;
	}

	@Override
	public User getUserByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUserByName(username);
	}

	@Override
	public ReturnResult<User> login(String loginName, String passwd,boolean rememberMe)
			throws Exception {

		Subject subject = SecurityUtils.getSubject();
		ReturnResult<User> res = new ReturnResult<User>();
		try {
			User u = userMapper.getUserByName(loginName);
			if (null == u) {
				res.setCode(ReturnResult.FAILURE);
				res.setMessage("用户[" + loginName + "]不存在！");
			} else {
				ShiroUsernamePasswordToken token  = new ShiroUsernamePasswordToken(u.getAccount(), passwd, u.getPassword(), u.getSalt(),null);
				token.setRememberMe(rememberMe);
				subject.login(token);
				if (subject.isAuthenticated()) {
					res.setCode(ReturnResult.SUCCESS);
					res.setMessage("登录成功！");
					res.setResultObject(u);
				} else {
					res.setCode(ReturnResult.FAILURE);
					res.setMessage("登录失败，密码错误。");
				}
			}
		} catch (ExcessiveAttemptsException ex) {
			res.setCode(ReturnResult.FAILURE);
			res.setMessage("登录失败，未知错误。");
		} catch (AuthenticationException ex) {
			res.setCode(ReturnResult.FAILURE);
			res.setMessage("登录失败，密码错误。");
		}
		return res;
	}

	@Override
	public void SaveorUpdateUser(User user) {
		// TODO Auto-generated method stub
		if(user.getId()>0){
			userMapper.updateByPrimaryKey(user);
		}else{
			userMapper.insert(user);
			updateCompanyUserNum(user.getCompanyId());
		}
		if(user.getRoleKey().equals("1")){
			if(user.getUserFunList()!=null){
				deleteUserFun(user);
				saveUserFun(user);
			}
		}else if(user.getRoleKey().equals("3")){
			if(user.getUserTypeList()!=null){
				deleteUserType(user);
				saveUserType(user);
			}
		}
	}

	private void deleteUserType(User user) {
		// TODO Auto-generated method stub
		userTypeMapper.deleteByUserId(user.getId());
	}

	private void deleteUserFun(User user) {
		// TODO Auto-generated method stub
		userFunctionMapper.deleteByUserId(user.getId());
	}

	private void updateCompanyUserNum(Integer companyId) {
		// TODO Auto-generated method stub
		Company company = companyMapper.selectByPrimaryKey(companyId);
		if(company!=null){
			if(company.getUserNum()!=null){
				company.setUserNum(company.getUserNum()+1);
			}else{
				company.setUserNum(1);
			}
			companyMapper.updateByPrimaryKey(company);
		}
		
	}

	private void saveUserType(User user) {
		// TODO Auto-generated method stub
		for(int f : user.getUserTypeList()){
			UserType ut = new UserType();
			ut.setId(0);
			ut.setMaintainanceKey(f+"");
			ut.setUserId(user.getId());
			userTypeMapper.insert(ut);
		} 
	}

	private void saveUserFun(User user) {
		// TODO Auto-generated method stub
		for(int f : user.getUserFunList()){
			UserFunction ut = new UserFunction();
			ut.setId(0);
			ut.setFunctionId(f);
			ut.setUserId(user.getId());
			userFunctionMapper.insert(ut);
		}
	}

	@Override
	public List<UserFunction> getUserFunListByUserId(Integer id) {
		// TODO Auto-generated method stub
		return userFunctionMapper.getUserFunListByUserId(id);
	}

	@Override
	public List<UserType> getUserTypeListByUserId(Integer id) {
		// TODO Auto-generated method stub
		return userTypeMapper.getUserTypeListByUserId(id);
	}

}
