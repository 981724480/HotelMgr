package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.model.Function;
import com.tianyi.yw.model.User;
@MyBatisRepository
public interface FunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
    

    /////主表自定义
    List<Function> getFunctionPageList(Function example);
    
    int getFunctionPageListCount(Function example);

    ReturnResult<Function> getFunctionById(Integer id);
    
    List<Function> getFunctionByParentId(Integer parentId);
}