package com.tianyi.yw.dao;

import com.tianyi.yw.model.TicketUser;

@MyBatisRepository
public interface TicketUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketUser record);

    int insertSelective(TicketUser record);

    TicketUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketUser record);

    int updateByPrimaryKey(TicketUser record);
}