<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="utf-8">
<title>客户管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1  ,maximum-scale=1, user-scalable=no" />
<script src="${pageContext.request.contextPath}/source/js/pager/jquery.pager.js"></script>
<script src="${pageContext.request.contextPath}/source/js/jquery.autocomplete.js"></script>
<script src="${pageContext.request.contextPath}/source/css/jquery.autocomplete.css"></script>
<link href="${pageContext.request.contextPath}/source/js/pager/Pager.css" rel="stylesheet" />
<script type="text/javascript">
	$(function() {
		//计算网页高度
		setHei();
		$(window).resize(function() {
			setHei();
		});
		
	});
	
	function setHei() {
		var h = $(window).height();
		var t = $("#content").offset().top;
		var v = h - t - 1;
		var rh = $("#conRight").height();
		if (rh > v) {
			v = rh + 20;
		}
		$("#content").css("height", v);
	}
	//单选框处理
	function clickRadio(obj) {
		var ck = $(obj).parent().find("input[type='radio']");
		var name = ck.prop("name");
		$("input[name=" + name + "]").each(function(i) {
			$(this).prev().removeClass("yw-radio-true");
		});
		if ($(obj).hasClass("yw-radio-true")) {
			$(obj).removeClass("yw-radio-true");
			ck.prop("checked", false);
		} else {
			$(obj).addClass("yw-radio-true");
			ck.prop("checked", true);
		}
		//获得选中的值
		var v = $("input[name=" + name + "]:checked").val();
		
		if(v==4){
			$("#sendTicket").show();
			$("#consult").hide();
			$("#su").show();
			$("#pp").hide();
		}else if(v==5){
			$("#sendTicket").hide();
			$("#consult").show();
			$("#su").show();
			$("#pp").hide();
			$("#cp").hide();
		}else{
			$("#sendTicket").show();
			$("#consult").hide();
			$("#su").hide();
			$("#pp").show();
			$("#cp").show();
		}
	}

	function saveProblem(){
		
		var ck = $("#problemForm").find("input[type='radio']:checked");
		if(ck.size()==1){
		 $('#problemForm').form('submit',{
		  		success:function(data){
		  			data = $.parseJSON(data);
		  			if(data.code==0){
		  				$.messager.alert('保存信息',data.message,'info',function(){
		  					//$('#calendarWindow').window('close');
		  					//search();
		  					
	        			});
		  			}else{
						$.messager.alert('错误信息',data.message,'error',function(){
							$(obj).attr("onclick", "saveProblem(this);"); 
	        			});
		  			}
		  		}
		  	 });
		}else{
			$.messager.alert('错误信息','请选择受理类型！','error');
		}
	
	}
	
	$(document).ready(function(){
		
		$("#sendTicket").show();
		$("#consult").hide();
		
	//电话好码自动搜索
	$("#phoneInfo").autocomplete("<%=basePath%>web/workstage/jsonLoadTicketSource.do",{
		   minChars: 1,  //最小显示条数  
		   max: 10,  //最大显示条数  
//		   scroll: true,//最多可以显示150个结果  
		   autoFill: false, 
		   selectFirst :true,
		   dataType : "json",  //指定数据类型的渲染方式   
		   width:170,
		   parse: function(data){
				var rows = [];
				for(var i=0;i<data.list.length;i++){
					rows[rows.length] = {      
		               data:data.list[i],      
		               value:data.list[i].callNumber,      
		               result:data.list[i].callNumber
		           };   
				}

				
				return rows;
			},
			formatItem: function(item){
				return item.callNumber;
			}
		  }).result (function(event, item) {
			  //alert(item.callNumber)
			  getTicketSource(item.callNumber);
		  }); 
	
	$("#phoneInfo").bind(
			"keyup",
			function(e,item) {
				
				var ev = document.all ? window.event : e;
			    if(ev.keyCode==13 && activeElementId=="phoneInfo") {
			    
			     }
			});
	
	
	//点位自动搜索
	
	$("#point").autocomplete("<%=basePath%>web/workstage/jsonLoadPoint.do",{
		   minChars: 1,  //最小显示条数  
		   max: 10,  //最大显示条数  
//		   scroll: true,//最多可以显示150个结果  
		   autoFill: false, 
		   selectFirst :true,
		   dataType : "json",  //指定数据类型的渲染方式   
		   width:170,
		   parse: function(data){
				var rows = [];
				for(var i=0;i<data.list.length;i++){
					rows[rows.length] = {      
		               data:data.list[i],      
		               value:data.list[i].callNumber,      
		               result:data.list[i].callNumber
		           };   
				}

				
				return rows;
			},
			formatItem: function(item){
				return item.callNumber;
			}
		  }).result (function(event, item) {
			  
		  }); 
	
	$("#point").bind(
			"keyup",
			function(e,item) {
				
				var ev = document.all ? window.event : e;
			    if(ev.keyCode==13 && activeElementId=="point") {
			    
			     }
			});
	
	 });
	
	function getTicketSource(param){
		
		$.ajax({  
	          type : "post",  
	          url : "<%=basePath%>web/workstage/jsonLoadTicketSourceInfo.do",  
	          data : "callNumber="+param,  
	          async : false,  
	          success : function(data){  
	        	  data = $.parseJSON(data); 
	        	  
	        	  $("#industry").combobox('setValue',data.obj.industry);
	        	  $("#contactor").val(data.obj.contactor); 
	        	  $("#clientName").val(data.obj.clientName); 
	        	  $("#district").combobox('setValue',data.obj.district);
	          }  
	          });  
	}

	function sendProblem(o){
		if(o==1){	
		 $('#win').window('open');
		}else{
			 $('#win').window('close');
		}
	}
	
	//复选框处理
	function loginBoxCheck(obj){
		var ck = $(obj).parent().find("input[type='radio']");
		var name = ck.prop("name");
		$("input[name=" + name + "]").each(function(i) {
			$(this).prev().removeClass("yw-radio-true");
		});
		if ($(obj).hasClass("yw-radio-true")) {
			$(obj).removeClass("yw-radio-true");
			ck.prop("checked", false);
		} else {
			$(obj).addClass("yw-radio-true");
			ck.prop("checked", true);
		}
		//获得选中的值
		var v = $("input[name=" + name + "]:checked").val();
		
		}
		
	
	function sendTicket(){
		var cku = $("#userlist").find("input[type='radio']:checked");
		var id = $(cku).val();
		$("#userTicketId").val(id);
		saveProblem();
		$("#win").window("close");
		
	}
</script>

</head>


<body>
		<div id="content">
			<div class="con-right" id="conRight">
				<div class="fl yw-lump">
					<div class="yw-lump-title">
						<i class="yw-icon icon-partner"></i><span>新建工单</span>
					</div>
				</div>
				<form action="<%=basePath%>web/workstage/jsonSaveTicket.do" method="post" id="problemForm">
				<div class="fl yw-lump mt10">
					<div class="pd10-28">
						<div class="yw-awo-info">
							<ul>
								<li><span class="fl wid82">来点时间：</span><input id="callTime" type="text"
									class="easyui-validatebox"  name="callTime" value="" placeholder="来电自动生成" /></li>
								<li><span class="fl wid82">来电号码：</span><input id="phoneInfo" type="text"
									class="easyui-validatebox" name="callNumber" value="" placeholder="来电自动生成"  />
									<input id="userTicketId" type="hidden" name="userTicketId" value=""  /></li>
									
								<li><span class="fl wid82">所属行业：</span><select id="industry" name="industry"
									class="easyui-combobox"><option>记录一次自动生成</option><option>676767676</option></select></li>
							</ul>
							<ul>
								<li><span class="fl wid82">联系人：</span><input id="contactor" type="text"
									class="easyui-validatebox" name="contactor" required="true"  value="" placeholder="来电自动生成" /></li>
								<li><span class="fl wid82">客户名称：</span><input id="clientName" type="text"
									class="easyui-validatebox" required="true"  validType="Length[1,25]" name="clientName" value="" placeholder="来电自动生成" /></li>
								<li><span class="fl wid82">所属市州：</span><select
									class="easyui-combobox" id="district" name="district"><option>记录一次自动生成</option><option>4444</option></select></li>
							</ul>
						</div>
						<p class="yw-p txt-center">
							<button class="yw-big-btn bg-green mt10 mb20 cur">填写更多资料</button>
							<button class="yw-big-btn bg-gray mt10 mb20 ml30 cur">历史保障记录</button>
						</p>
						<div class="cl"></div>
					</div>
				</div>
				<div class="fl yw-cm-rows">
					<div class="pd10-28 pb0">
						<span class="fl">受理类型*：</span> <label class="yw-radio"><i
							class="mt12 mr10 ml30 " onclick="clickRadio(this);"></i><input
							type="radio" name="sllx" value="1"/>前端点位</label> <label
							class="yw-radio"><i class="mt12 mr10 ml30"
							onclick="clickRadio(this);"></i><input type="radio" name="sllx"
							value="2" />监控中心</label> <label class="yw-radio"><i
							class="mt12 mr10 ml30" onclick="clickRadio(this);"></i><input
							type="radio" name="sllx" value="3" />中心平台</label> <label
							class="yw-radio"><i class="mt12 mr10 ml30"
							onclick="clickRadio(this);"></i><input type="radio" name="sllx"
							value="4" />技术支撑</label> <label class="yw-radio"><i
							 class="mt12 mr10 ml30" onclick="clickRadio(this);"></i><input
							type="radio"  name="sllx" value="5" />业务咨询</label>
						<div class="cl"></div>
					</div>
				</div>
				<div class="fl yw-lump mt10">
					<div class="pd10-28">
						<div class="yw-awo-info">
						
							<ul>
								<li><span class="fl wid82">单号：</span><input type="text"
									class="easyui-textbox" required="true"  validType="Length[1,25]" name="ticketNumber" value="" placeholder="来电自动生成" /></li>
								<li><span class="fl wid82">录单人：</span><input type="text"
									class="easyui-textbox" required="true"  validType="Length[1,25]" name="userId" value="" placeholder="来电自动生成" /></li>
								<li><span class="fl wid82">录单时间：</span><input type="text"
									class="easyui-textbox" name="createTime" value="" placeholder="系统自动生成" /></li>
							</ul>
							<div id="pp">
							 <ul>
                            	<li class="fit"><span class="fl wid102">故障点位*：</span>
                                <input id ="point" type="text" class="yw-awoi-input wid60-percent" value="" placeholder="请输入关键字搜索"/>
                                <button class="yw-little-btn bg-orange ml10 mt-2">搜索</button>
                                </li>
                            </ul>
                            <ul>
                            	<li><span class="fl wid102">所属项目：</span><input id="bp" type="text" class="yw-awoi-input no-border" value="" placeholder="根据选择点位自动生成"/></li>
                                <li><span class="fl wid102">重要程度：</span><input id="il" type="text" class="yw-awoi-input no-border" value="" placeholder="根据选择点位自动生成"/></li>
                                <li><span class="fl wid102">处理时间：</span><input id="dt" type="text" class="yw-awoi-input no-border" value="" placeholder="根据选择点位自动生成"/></li>
                            </ul>
                            <ul>
                            	<li class="fit"><span class="fl wid102">故障现象*：</span>
                                <input id="tv" type="text" class="yw-awoi-input wid70-percent"  value="" />
                                </li>
                            </ul>
                            </div>
                            <ul id="su">
								<li class="fit"><span class="fl wid102">摘要*：</span><select
									class="easyui-combobox" name="summary"><option>请选择摘要内容</option></select></li>

							</ul>
							
                            <ul id="cp">
                            	<li class="fit"><span class="fl wid102">客户手机*：</span>
                                <input type="text" class="fl yw-awoi-input mt10" name="clientPhone" required="true"  validType="Length[1,25]" value="" />
                                <label class="yw-checkbox">
                                	<i class="yw-checkbox-true mt17 mr10 ml10" onClick="loginCheck(this);"></i><input type="checkbox" id="ywCheckbox" name="ywCheckbox" checked="checked" value="1">推送运维过程
                                </label>
                                </li>
                            </ul>
                            <ul>
                            	<li class="fit mb20">
                                	<span class="fl wid102">详细描述*：</span>
                                    <textarea class="yw-textarea wid70-percent" name="comment"></textarea>
                                </li>
                            </ul>
							<ul id="sendTicket">
								<li class="fit mt10 mb20 txt-center">
									<span class="yw-big-btn bg-orange wid160 mt10 mb20 ml30 cur" onclick="saveProblem();">保存</span>
									<span class="yw-big-btn bg-orange wid160 mt10 mb20 ml30 cur"  onclick="sendProblem(1);">派单</span>
								</li>
								</ul>
							<ul id="consult">
								<li class="fit mt10 mb20 txt-center">
									<span class="yw-big-btn bg-orange wid160 mt10 mb20 ml30 cur" onclick="saveProblem();">处理解决</span>
								</li>
								</ul>
						</div>
						
						</form>
					</div>
				</div>

				<div class="cl"></div>
			</div>
			<div class="cl"></div>
		</div>
	</div>
	
	    <div id="win" class="easyui-window" title="派单工单" data-options="iconCls:'icon-help',shadow:false,collapsible:false,closed:true" style="width:560px;height:560px;padding:10px;">
    	<div class="pd10">
            <p class="yw-p font-size14">
                <span class="color-blue">单号：</span>
            </p>
            <p class="yw-window-p font-size14">
            	<span class="color-blue">产生日期：</span>
            </p>
            <p class="yw-p font-size14">
            	<div class="yw-woh-region">
                	<table class="yw-woh-table" id="userlist">
                	<c:forEach var="item" items="${userlist}">
						<tr>
						<input type="hidden" name="userId" value="${item.id}"/>
						<td align="center">${item.id}</td>
                        	<td width="50%"><label class="yw-radio"><i class="mt9 ml10 mr10" onClick="loginBoxCheck(this);"></i><input type="radio" name="ck2" value="${item.id}" checked="">${item.companyName}</label></td>
                            <td width="5%"> | </td><td>${item.name}</td><td><span class="color-gray">（前端）</span></td>
                        </tr>
					</c:forEach>
                    	
                    </table>
                </div>
            </p>
       	</div>
        <div class="yw-window-footer txt-center">
			<button class="yw-window-btn bg-blue mt12" onclick="sendTicket();">提交数据</button>
			<button class="yw-window-btn bg-blue mt12" onclick="sendProblem(2);">退出</button>
        </div>
	</div>
</body>
</html>
