package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.model.Function;
import com.tianyi.yw.model.User;

public interface FunctionService {

	int deleteFunction(Integer id);

    int saveFunction(Function record);

    int updateFunction(Function record);
    
    
    /////主表自定义
    List<Function> getFunctionPageList(Function example);
    
    int getFunctionPageListCount(Function example);

    ReturnResult<Function> getFunctionById(Integer id);
    
    
    List<Function> getFunctionByUserId(Integer userId);
    
    List<Function> getFunctionByParentId(Integer parentId);
}
