package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.User;
@MyBatisRepository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    ////////////////
    
    List<User> getUserPageList(User example);
    
    int getUserPageListCount(User example);
    
    User getUserByName(String username);
    
    User getUserById(Integer id);

}