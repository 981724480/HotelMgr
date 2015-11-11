package com.tianyi.yw.dao;

import java.util.List;

import com.tianyi.yw.model.TicketSource;

@MyBatisRepository
public interface TicketSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketSource record);

    int insertSelective(TicketSource record);

    TicketSource selectByPrimaryKey(Integer id);
    
    
    List<TicketSource>  selectByPhoneCallList(String callNumber);
    
    TicketSource  selectByPhoneCallInfo(String callNumber);

    int updateByPrimaryKeySelective(TicketSource record);

    int updateByPrimaryKey(TicketSource record);
}