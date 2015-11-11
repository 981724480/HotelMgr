package com.tianyi.yw.dao;

import com.tianyi.yw.model.ProcessNode;

@MyBatisRepository
public interface ProcessNodeMapper {
    int deleteByPrimaryKey(Integer nodeId);

    int insert(ProcessNode record);

    int insertSelective(ProcessNode record);

    ProcessNode selectByPrimaryKey(Integer nodeId);

    int updateByPrimaryKeySelective(ProcessNode record);

    int updateByPrimaryKey(ProcessNode record);
}