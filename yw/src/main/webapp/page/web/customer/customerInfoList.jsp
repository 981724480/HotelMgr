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
<link href="${pageContext.request.contextPath}/source/js/pager/Pager.css" rel="stylesheet" />
<script type="text/javascript">
$(document).ready(function(){
	$("#pager").pager({
			    pagenumber:'${customerCompany.pageNo}',                         /* 表示初始页数 */
			    pagecount:'${customerCompany.pageCount}',                      /* 表示总页数 */
			    totalCount:'${customerCompany.totalCount}',
			    buttonClickCallback:PageClick                     /* 表示点击分页数按钮调用的方法 */                  
	});
	$("#customerList tr").each(function(i){
		if(i>0){
			$(this).bind("click",function(){
				var customerId = $(this).find("td").first().text();
				 window.location.href="customerdetail.do?customerId="+customerId;
			});
		}
	});
});
PageClick = function(pageclickednumber) {
	$("#pager").pager({
	    pagenumber:pageclickednumber,                 /* 表示启示页 */
	    pagecount:'${customerCompany.pageCount}',                  /* 表示最大页数pagecount */
	    buttonClickCallback:PageClick                 /* 表示点击页数时的调用的方法就可实现javascript分页功能 */            
	});
	
	$("#pageNumber").val(pageclickednumber);          /* 给pageNumber从新赋值 */
	/* 执行Action */
	pagesearch();
}
function search(){
	$("#pageNumber").val("1");
	pagesearch();
}

function pagesearch(){
	customerCompanyForm.submit();
}

function showdialog(){
	var wz = getDialogPosition($('#calendarWindow').get(0),100);
	$('#calendarWindow').window({
		  	top: 100,
		    left: wz[1],
		    onBeforeClose: function () {
		    
			
		    }
	});
	$('#calendarWindow').window('open');
}

function saveCompany(obj){
	if ($('#saveCompanyForm').form('validate')) {
		$(obj).attr("onclick", ""); 
		 $('#saveCompanyForm').form('submit',{
		  		success:function(data){
		  			data = $.parseJSON(data);
		  			if(data.code==0){
		  				$.messager.alert('保存信息',data.message,'info',function(){
		  					$('#calendarWindow').window('close');
		  					search();
	        			});
		  			}else{
						$.messager.alert('错误信息',data.message,'error',function(){
							$(obj).attr("onclick", "saveCompany(this);"); 
	        			});
		  			}
		  		}
		  	 });  
	}
}
</script>
</head>

  
  <body>
     <div class="con-right" id="conRight">
 		<div class="fl yw-lump">
           	<div class="yw-lump-title">
               	<i class="yw-icon icon-partner"></i><span>客户列表</span>
               </div>
           </div>
           <div class="fl yw-lump mt10">
           <form  id="customerCompanyForm" name="customerCompanyForm" action="customerinfo.do" method="get">
           	<div class="pd10-28">
                   <div class="fl">
                       <!-- <button class="yw-btn bg-blue cur">全部客户</button> --><!-- <button class="yw-btn bg-gray ml20 cur">满意度调查</button> -->
                   </div>
                   <div class="fr">
                   	<input type="text" name="searchName" class="yw-input wid170" placeholder="搜索" value="${customerCompany.searchName}" />
                   	<!-- <button class="yw-btn bg-orange ml30 cur" type="submit" onclick="search();">开始查找</button> -->
                   	<!-- <button class="yw-btn bg-green ml20 cur" onclick="showdialog();">新建公司</button> -->
                   	<span class="yw-btn bg-orange ml30 cur" onclick="search();">开始查找</span>
                   	<span class="yw-btn bg-green ml20 cur" onclick="showdialog();">新建公司</span>
                   </div>
                   <div class="cl"></div>
               </div>
               
               <input type="hidden" id="pageNumber" name="pageNo" value="${customerCompany.pageNo}" />
               </form>
           </div>
           <!-- <div class="fl yw-cm-rows">
           	<div class="pd10-28 pb0">
                   <span class="fl">  共 3 页,46项</span>
                   <span class="fr">统计范围：2015-10-01 至 2015-10-30</span>
                   <div class="cl"></div>
               </div>
           </div> -->
           <div class="fl yw-lump">
           	<div class="yw-cm-title">
               	<span class="ml26">全部客户</span>
               </div>
           	<table class="yw-cm-table"  id="customerList">
               	<tr>
                   	<th width="4%"></th><th>客户名称</th><th>联系人</th><th>客户类型</th>
                   </tr>
                   <c:forEach var="item"  items="${customerCompanylist}">
                   		<tr>
		                   <td align="center">${item.id}</td><td>${item.name}</td><td>${item.userNum==null?0:item.userNum}位</td><td>${item.typeKey}</td>
		                </tr>
                   </c:forEach>
               </table>
                <div class="page" id="pager">
        	
        		</div>
           </div>
 	  </div>
 	  
 	  
 	  <div id="calendarWindow" class="easyui-window" title="新添加公司" style="width:560px;height:360px;overflow:hidden;padding:10px;" class="easyui-window" iconCls="icon-info" closed="true" modal="true"   resizable="false" collapsible="false" minimizable="false" maximizable="false">
		<form id="saveCompanyForm" name ="saveCompanyForm" action="jsonSaveOrupdateCompany.do"  method="post">
		<p class="yw-window-p">
        	<span class="fl">公司名称：</span><input name="name" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">上级机构：</span><input  name="vvvvv" class="easyui-combotree"   url="jsonLoadCustomerCompanyParent.do?parentId=146" style="width:254px;height:30px;" value="" data-options="valueField:'id',textField:'text'"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">所在区域：</span><input name="district" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">联系地址：</span><input name="address" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">邮政编码：</span><input name="code" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <div class="yw-window-footer txt-right">
        	<span class="yw-window-btn bg-lightgray mt12" onclick="$('#calendarWindow').window('close');">退出</span>
        	<span class="yw-window-btn bg-blue mt12" onclick="saveCompany(this);">保存</span>
        </div>
        </form>
	</div>
  </body>
</html>
