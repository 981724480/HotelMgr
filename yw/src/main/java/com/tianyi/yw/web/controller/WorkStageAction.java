package com.tianyi.yw.web.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.yw.common.JsonResult;
import com.tianyi.yw.common.ReturnResult;
import com.tianyi.yw.common.utils.DateUtil;
import com.tianyi.yw.model.Ticket;
import com.tianyi.yw.model.TicketSource;
import com.tianyi.yw.model.User;
import com.tianyi.yw.service.WorkStageService;

@Scope("prototype")
@Controller
@RequestMapping("/web/workstage")
public class WorkStageAction extends BaseAction{
	
	@Resource
	private WorkStageService workStageService;
	
	private static Log logger = LogFactory.getLog(WorkStageAction.class);
	
	@RequestMapping(value="/ticket.do", method=RequestMethod.GET)
	public ModelAndView ticket(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView();  
		List<User> ts = this.workStageService.getUserList();
		mav.addObject("userlist", ts);
		mav.setViewName("web/workbench/tickets");
		
	     return mav;
	}
	
	@RequestMapping(value="/ticketList.do", method=RequestMethod.GET)
	public ModelAndView ticketList(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView();  
		
		mav.setViewName("web/workbench/ticketList");
		
	     return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/jsonSaveTicket.do",method=RequestMethod.POST)
	public JsonResult jsonSaveTicket(HttpServletRequest request, HttpServletResponse response){

		JsonResult js = new JsonResult();
		
		String userTicketId = request.getParameter("userTicketId");
		
		String callTime = request.getParameter("callTime");
		String callNumber = request.getParameter("callNumber");
		String industry = request.getParameter("industry");
		String contactor = request.getParameter("contactor");
		String clientName = request.getParameter("clientName");
		String district = request.getParameter("district");
		
		
		String sllx = request.getParameter("sllx");
		String ticketNumber = request.getParameter("ticketNumber");
		String userId = request.getParameter("userId");
		String createTime = request.getParameter("createTime");
		String summary = request.getParameter("summary");
		String comment = request.getParameter("comment");
		String clientPhone = request.getParameter("clientPhone");
		String pointId = request.getParameter("pointId");
		String projectId = request.getParameter("projectId");
		String messageSend = request.getParameter("messageSend");
		
		Map map = new HashMap();
		
		
		TicketSource ticketSource = new TicketSource();
		try {
			ticketSource.setCallTime(callTime.equals("")?new Date():DateUtil.parse(callTime, "yyyy-MM-dd"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ticketSource.setCallNumber(callNumber);
		ticketSource.setClientName(clientName);
		ticketSource.setContactor(contactor);
		ticketSource.setIndustry(industry);
		ticketSource.setDistrict(district);
		map.put("ticketSource", ticketSource);
		
		Ticket ticket = new Ticket();
		
		ticket.setTicketNumber(ticketNumber);
		ticket.setUserId(userId.equals("")?1:Integer.valueOf(userId));
		
		try {
			ticket.setCreateTime(createTime.equals("")?new Date():DateUtil.parse(createTime, "yyyy-MM-dd"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.info(e);
		}
		
		ModelAndView mav = new ModelAndView(); 
		
		//保存报障工单
		if("1".equals(sllx)){
			
			ticket.setTypeKey(sllx);
			ticket.setClientPhone(clientPhone);
			ticket.setComment(comment);
			
			
			map.put("ticket", ticket);
			js.setCode(new Integer(1));
			js.setMessage("保存失败!");
			try {
				
				//派单保存
				if(!"".equals(userTicketId)&&null!=userTicketId){
					
					map.put("userTicketId", userTicketId);
					
					ticket.setStatus(2);
					js.setCode(new Integer(2));
					js.setMessage("派单成功!");
				}else{
					
					//普通保存
					ticket.setStatus(1);
					js.setCode(new Integer(1));
					js.setMessage("保存成功!");
				}
				
				workStageService.saveProblemTicket(map);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//保存支撑工单
		if("4".equals(sllx)){
			ticket.setTypeKey(sllx);
			ticket.setClientPhone(clientPhone);
			ticket.setComment(comment);
			ticket.setSummary(summary);
			
			map.put("ticket", ticket);
			js.setCode(new Integer(1));
			js.setMessage("保存失败!");
			try {
				
				//派单保存
				if(!"".equals(userTicketId)&&null!=userTicketId){
					
					map.put("userTicketId", userTicketId);
					
					ticket.setStatus(2);
					js.setCode(new Integer(2));
					js.setMessage("派单成功!");
				}else{
					
					//普通保存
					ticket.setStatus(1);
					js.setCode(new Integer(1));
					js.setMessage("保存成功!");
				}
				
				workStageService.saveSupportTicket(map);
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		//保存咨询工单
		if("5".equals(sllx)){
			ticket.setTypeKey(sllx);
			ticket.setSummary(summary);
			ticket.setComment(comment);
			ticket.setStatus(1);
			
			map.put("ticket", ticket);
			
			js.setCode(new Integer(1));
			js.setMessage("保存失败!");
			try {
				String code  = workStageService.saveConsultTicket(map);
				js.setCode(new Integer(0));
				js.setMessage("保存成功!");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return js;
	}
	
	
	
	@RequestMapping(value="/getTicketDetail.do", method=RequestMethod.GET)
	public ModelAndView getTicketDetail(HttpServletRequest request, HttpServletResponse response){
		
			ModelAndView mav = new ModelAndView();  
		
			mav.setViewName("web/workbench/ticketdetail");
		
	     return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/jsonLoadTicketSource.do", method=RequestMethod.POST)
	public JsonResult jsonLoadTicketSource(HttpServletRequest request, HttpServletResponse response){
		
		String callNumber = request.getParameter("q");
		JsonResult jr = new JsonResult(); 
		List<TicketSource> ts = this.workStageService.getTicketSource(callNumber);
		
		jr.setList(ts);
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value="/jsonLoadPoint.do", method=RequestMethod.POST)
	public JsonResult jsonLoadPoint(HttpServletRequest request, HttpServletResponse response){
		
		String callNumber = request.getParameter("q");
		JsonResult jr = new JsonResult(); 
		List<TicketSource> ts = this.workStageService.getTicketSource(callNumber);
		
		jr.setList(ts);
		return jr;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/jsonLoadTicketSourceInfo.do", method=RequestMethod.POST)
	public JsonResult jsonLoadTicketSourceInfo(HttpServletRequest request, HttpServletResponse response){
		
		String callNumber = request.getParameter("callNumber");
		JsonResult jr = new JsonResult(); 
		TicketSource ts = this.workStageService.getTicketSourceInfo(callNumber);
		
		jr.setObj(ts);
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value="/jsonLoadPointInfo.do", method=RequestMethod.POST)
	public JsonResult jsonLoadPointInfo(HttpServletRequest request, HttpServletResponse response){
		
		String callNumber = request.getParameter("callNumber");
		JsonResult jr = new JsonResult(); 
		TicketSource ts = this.workStageService.getTicketSourceInfo(callNumber);
		
		jr.setObj(ts);
		return jr;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/jsonLoadUserList.do", method=RequestMethod.POST)
	public JsonResult<User> jsonLoadUserList(HttpServletRequest request, HttpServletResponse response){
		
		JsonResult<User> rr=new JsonResult<User>();
		List<User> ts = this.workStageService.getUserList();
		
		request.setAttribute("userlist", ts);
		rr.setList(ts);
		
		return rr;
	}
	@ResponseBody
	@RequestMapping(value="/jsonSaveSendTicket.do", method=RequestMethod.POST)
	public JsonResult<User> jsonSaveSendTicket(HttpServletRequest request, HttpServletResponse response){
		
		String id = request.getParameter("id");
		
		
		JsonResult<User> rr=new JsonResult<User>();
		List<User> ts = this.workStageService.getUserList();
		
		request.setAttribute("userlist", ts);
		rr.setList(ts);
		
		return rr;
	}
	
}
  