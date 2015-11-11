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
			    pagenumber:'${project.pageNo}',                         /* 表示初始页数 */
			    pagecount:'${project.pageCount}',                      /* 表示总页数 */
			    totalCount:'${project.totalCount}',
			    buttonClickCallback:PageClick                     /* 表示点击分页数按钮调用的方法 */                  
	});
	$("#projectList tr").each(function(i){
		if(i>0){
			$(this).bind("click",function(){
				var projectId = $(this).find("td").first().text();
				 window.location.href="projectInfo.do?projectId="+projectId;
			});
		}
	});
});
PageClick = function(pageclickednumber) {
	$("#pager").pager({
	    pagenumber:pageclickednumber,                 /* 表示启示页 */
	    pagecount:'${project.pageCount}',                  /* 表示最大页数pagecount */
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
	projectForm.submit();
}  
function setTimeSpan(projectId){
};
function setProjectArea(projectId){
};
</script>
</head>

  
  <body>
     <div class="con-right" id="conRight">
 		<div class="fl yw-lump">
           	<div class="yw-lump-title">
               	<i class="yw-icon icon-partner"></i><span>项目管理</span>
               </div>
           </div>
           <div class="fl yw-lump mt10">
           <form  id="projectForm" name="projectForm" action="projectList.do" method="get">
           	<div class="pd10-28">
                   <div class="fl">
                       <!-- <button class="yw-btn bg-blue cur">全部客户</button> --><!-- <button class="yw-btn bg-gray ml20 cur">满意度调查</button> -->
                   </div>
                   <div class="fr">
                   	<input type="text" name="searchName" class="yw-input wid170" placeholder="搜索" value="${project.searchName}" />
                   	<!-- <button class="yw-btn bg-orange ml30 cur" type="submit" onclick="search();">开始查找</button> -->
                   	<!-- <button class="yw-btn bg-green ml20 cur" onclick="showdialog();">新建公司</button> -->
                   	<span class="yw-btn bg-orange ml30 cur" onclick="search();">开始查找</span>
                   	<span class="yw-btn bg-green ml20 cur" onclick="window.location.href='projectInfo.do?projectId=0';">新建项目</span>
                   </div>
                   <div class="cl"></div>
               </div>
               
               <input type="hidden" id="pageNumber" name="pageNo" value="${project.pageNo}" />
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
               	<span class="ml26">全部项目</span>
               </div>
           	<table class="yw-cm-table"  id="projectList">
               	<tr>
                   	<th width="4%"></th><th>项目名称</th><th>维护点位</th><th>维护区域</th><th>维护人员</th><th>维护时限</th><th>维护区域</th>
                   </tr>
                   <c:forEach var="item"  items="${projectlist}">
                   		<tr>
		                   <td align="center">${item.id}</td><td>${item.name}</td><td>${item.pointCount}</td><td>${item.areaName}</td><td>${item.userName}</td>
		                   <td><span class="yw-btn bg-orange ml30 cur" onclick="setTimeSpan(${item.id});">设置</span></td>
		                   <td><span class="yw-btn bg-orange ml30 cur" onclick="setProjectArea(${item.id});">设置</span></td>
		                </tr>
                   </c:forEach>
               </table>
                <div class="page" id="pager">
        	
        		</div>
           </div>
 	  </div>
  </body>
</html>
