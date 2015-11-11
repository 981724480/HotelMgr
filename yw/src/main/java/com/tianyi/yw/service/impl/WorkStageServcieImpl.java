package com.tianyi.yw.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.dao.TicketMapper;
import com.tianyi.yw.dao.TicketSourceMapper;
import com.tianyi.yw.dao.TicketUserMapper;
import com.tianyi.yw.dao.UserMapper;
import com.tianyi.yw.model.Ticket;
import com.tianyi.yw.model.TicketSource;
import com.tianyi.yw.model.TicketUser;
import com.tianyi.yw.model.User;
import com.tianyi.yw.service.WorkStageService;

@Service("workStageService")
public class WorkStageServcieImpl implements WorkStageService {
	
	@Resource
	TicketMapper ticketMapper;
	
	@Resource
	TicketSourceMapper ticketSourceMapper;
	
	@Resource
	UserMapper userMapper;
	
	
	@Resource
	TicketUserMapper ticketUserMapper;
	
	

	@Override
	public Integer saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketMapper.insert(ticket);
		return ticket.getId();
	}

	@Override
	public Integer saveTicketSource(TicketSource ticketSource) {
		
		TicketSource ts =this.ticketSourceMapper.selectByPhoneCallInfo(ticketSource.getCallNumber());
		if(null==ts){
			
			ticketSourceMapper.insert(ticketSource);
			return ticketSource.getId();
		}
		return ts.getId();
	}
	
	@Override
	public int updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ticket> getTicketPageList(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketPageListCount(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnResult<Ticket> getTicketById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String  saveConsultTicket(Map map) {
		// TODO Auto-generated method stub
		
		
		
		Ticket ticket =(Ticket)map.get("ticket");
		TicketSource ticketSource =(TicketSource)map.get("ticketSource");
		Integer i = saveTicketSource(ticketSource);
		ticket.setSourceId(i);
		ticketMapper.insert(ticket);
		
		
		return "success";
		
	}

	@Override
	public String saveProblemTicket(Map map) {
		Ticket ticket =(Ticket)map.get("ticket");
		TicketSource ticketSource =(TicketSource)map.get("ticketSource");
		
		Integer i = saveTicketSource(ticketSource);
		ticket.setSourceId(i);
		ticketMapper.insert(ticket);
		
		
		if(ticket.getStatus()==2){
			Integer userTicketId = Integer.valueOf((String)map.get("userTicketId"));
			
			TicketUser ticketUser = new TicketUser();
			ticketUser.setTicketId(ticket.getId());
			ticketUser.setStatus(2);
			ticketUser.setDispatchUser(userTicketId);
			ticketUser.setDispatchTime(new Date());
			ticketUser.setUserId(1);
			ticketUserMapper.insert(ticketUser);
			
		}
		
		
		
		return "success";
	}

	@Override
	public String saveSupportTicket(Map map) {
		Ticket ticket =(Ticket)map.get("ticket");
		TicketSource ticketSource =(TicketSource)map.get("ticketSource");
		Integer i = saveTicketSource(ticketSource);
		ticket.setSourceId(i);
		ticketMapper.insert(ticket);
		
		if(ticket.getStatus()==2){
			Integer userTicketId = Integer.valueOf((String)map.get("userTicketId"));
			
			TicketUser ticketUser = new TicketUser();
			ticketUser.setTicketId(ticket.getId());
			ticketUser.setStatus(2);
			ticketUser.setDispatchUser(userTicketId);
			ticketUser.setDispatchTime(new Date());
			ticketUser.setUserId(1);
			ticketUserMapper.insert(ticketUser);
			
		}
		
		return "success";
	}

	@Override
	public List<TicketSource> getTicketSource(String callNumber) {
		return ticketSourceMapper.selectByPhoneCallList(callNumber);
	}

	@Override
	public TicketSource getTicketSourceInfo(String callNumber) {
		// TODO Auto-generated method stub
		return ticketSourceMapper.selectByPhoneCallInfo(callNumber);
	}

	@Override
	public TicketSource getPoint(String pointName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketSource getPointInfo(String pointName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userMapper.getUserPageList(new User());
	}

	

}
