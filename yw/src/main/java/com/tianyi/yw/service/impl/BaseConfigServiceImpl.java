package com.tianyi.yw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.dao.BaseConfigMapper;
import com.tianyi.yw.model.BaseConfig;
import com.tianyi.yw.service.BaseConfigService;
@Service("baseConfigService")
public class BaseConfigServiceImpl implements BaseConfigService {

	@Resource
	private BaseConfigMapper baseConfigMapper;
	
	@Override
	public int deleteConfig(Integer id) {
		// TODO Auto-generated method stub
		return baseConfigMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveConfig(BaseConfig record) {
		// TODO Auto-generated method stub
		return baseConfigMapper.insertSelective(record);
	}

	@Override
	public BaseConfig selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return baseConfigMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateConfig(BaseConfig record) {
		// TODO Auto-generated method stub
		return baseConfigMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<BaseConfig> getBaseConfigByWhere(Integer typeId,
			Integer parentId) {
		BaseConfig b = new BaseConfig();
		b.setTypeId(typeId);
		b.setParentKey(parentId);
		return baseConfigMapper.getBaseConfigByWhere(b);
	}

}
