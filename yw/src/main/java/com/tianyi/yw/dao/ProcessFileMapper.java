package com.tianyi.yw.dao;

import com.tianyi.yw.model.ProcessFile;
/**
 * 
 * @author aixiaoliang
 *
 */

@MyBatisRepository
public interface ProcessFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessFile record);

    int insertSelective(ProcessFile record);

    ProcessFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessFile record);

    int updateByPrimaryKey(ProcessFile record);
}