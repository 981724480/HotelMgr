package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.Point;
@MyBatisRepository
public interface PointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
    
    //////
    
    List<Point> getPointPageList(Point record);
    
    int getPointPageListCount(Point record);
}