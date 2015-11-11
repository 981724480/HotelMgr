package com.tianyi.yw.service;

import java.util.List;
import java.util.Map;

import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.model.Ticket;
import com.tianyi.yw.model.TicketSource;
import com.tianyi.yw.model.User;

public interface WorkStageService {
	
	//保存工单
	Integer saveTicket(Ticket ticket);
	
	//保存工单来源
	Integer saveTicketSource(TicketSource ticketSource);
	
	//更新工单
	int updateTicket(Ticket ticket);
	
	//删除工单
	int deleteTicket(Ticket ticket);

	//查询工单列表分页
	List<Ticket> getTicketPageList(Ticket ticket);

	//查询工单数量
	List<Ticket> getTicketPageListCount(Ticket ticket);
	
	//查询工单详情
	ReturnResult<Ticket> getTicketById(Integer id);
	
	String saveConsultTicket(Map map);
	
	String saveProblemTicket(Map map);
	String saveSupportTicket(Map map);
	
	//自动搜素工单资源
	List<TicketSource> getTicketSource(String callNumber);
	TicketSource getTicketSourceInfo(String callNumber);
	
	//自动搜索点位
	TicketSource getPoint(String pointName);
	TicketSource getPointInfo(String pointName);
	
	
	List<User> getUserList();

}
