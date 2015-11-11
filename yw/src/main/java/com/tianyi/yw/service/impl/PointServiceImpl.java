package com.tianyi.yw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.dao.PointMapper;
import com.tianyi.yw.dao.ProjectMapper;
import com.tianyi.yw.model.Point;
import com.tianyi.yw.service.PointService;

@Service("pointService")
public class PointServiceImpl implements PointService {

	@Resource
	private ProjectMapper projectMapper; 
	
	@Resource
	private PointMapper pointMapper;
	
	
	@Override
	public int deletePoint(Integer id) {
		// TODO Auto-generated method stub
		return pointMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int savePoint(Point record) {
		// TODO Auto-generated method stub
		return pointMapper.insertSelective(record);
	}

	@Override
	public Point selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return pointMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updatePoint(Point record) {
		// TODO Auto-generated method stub
		return pointMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Point> getPointPageList(Point record) {
		// TODO Auto-generated method stub
		return pointMapper.getPointPageList(record);
	}

	@Override
	public int getPointPageListCount(Point record) {
		// TODO Auto-generated method stub
		return pointMapper.getPointPageListCount(record);
	}

}
