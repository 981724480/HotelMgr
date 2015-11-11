package com.tianyi.yw.service;

import java.util.List;

import com.tianyi.yw.model.Point;

public interface PointService {

	 	int deletePoint(Integer id);

	    int savePoint(Point record);

	    Point selectByPrimaryKey(Integer id);

	    int updatePoint(Point record);
	    
	    //////
	    
	    List<Point> getPointPageList(Point record);
	    
	    int getPointPageListCount(Point record);
	    
	    
}
