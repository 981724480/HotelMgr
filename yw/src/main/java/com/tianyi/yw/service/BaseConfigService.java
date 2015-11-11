package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.model.BaseConfig;

public interface BaseConfigService {
	
	    int deleteConfig(Integer id);

	    int saveConfig(BaseConfig record);

	    BaseConfig selectByPrimaryKey(Integer id);

	    int updateConfig(BaseConfig record);
	    
	    List<BaseConfig> getBaseConfigByWhere(Integer typeId,Integer parentId);
}
