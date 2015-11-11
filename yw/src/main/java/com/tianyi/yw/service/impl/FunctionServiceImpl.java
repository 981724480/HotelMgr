package com.tianyi.yw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.dao.FunctionMapper;
import com.tianyi.yw.dao.UserFunctionMapper;
import com.tianyi.yw.model.Function;
import com.tianyi.yw.model.UserFunction;
import com.tianyi.yw.service.FunctionService;
@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	
	@Resource
	private FunctionMapper functionMapper;
	@Resource
	private UserFunctionMapper userFunctionMapper;
	
	@Override
	public int deleteFunction(Integer id) {
		// TODO Auto-generated method stub
		return functionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveFunction(Function record) {
		// TODO Auto-generated method stub
		return functionMapper.insertSelective(record);
	}

	@Override
	public int updateFunction(Function record) {
		// TODO Auto-generated method stub
		return functionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Function> getFunctionPageList(Function example) {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionPageList(example);
	}

	@Override
	public int getFunctionPageListCount(Function example) {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionPageListCount(example);
	}

	@Override
	public ReturnResult<Function> getFunctionById(Integer id) {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionById(id);
	}

	@Override
	public List<Function> getFunctionByUserId(Integer userId) {
		List<UserFunction> lf = userFunctionMapper.getFunctionByUserId(userId);
		
		List<Function> mainlist = new ArrayList<Function>();
		for(UserFunction uf:lf){
			if(uf.getFunction().getParentId()==0){
				Function function  = uf.getFunction();
				function.setChildFunctionlist(getChildrenList(lf,function.getId()));
				mainlist.add(function);
			}
		}
		return mainlist;
	}
	
	private List<Function> getChildrenList(List<UserFunction> lf,Integer parentFunctionId){
		List<Function> mainlist = new ArrayList<Function>();
		for(UserFunction uf:lf){
			if(uf.getFunction().getParentId()==parentFunctionId){
				Function function  = uf.getFunction();
//				function.setChildFunctionlist(getChildrenList(lf));
				mainlist.add(function);
			}
		}
		return mainlist;
	}

	@Override
	public List<Function> getFunctionByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionByParentId(parentId);
	}

}
