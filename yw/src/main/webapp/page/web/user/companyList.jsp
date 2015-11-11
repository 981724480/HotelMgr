<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="utf-8"> 
<title>员工管理</title> 
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1  ,maximum-scale=1, user-scalable=no" />
<script
	src="${pageContext.request.contextPath}/source/js/pager/jquery.pager.js"></script>
<link
	href="${pageContext.request.contextPath}/source/js/pager/Pager.css"
	rel="stylesheet" />
<script type="text/javascript">
		$(document).ready(function(){
			$("#pager").pager({
			    pagenumber:'${userCompany.pageNo}',                         /* 表示初始页数 */
			    pagecount:'${userCompany.pageCount}',                      /* 表示总页数 */
			    totalCount:'${userCompany.totalCount}',
			    buttonClickCallback:PageClick                     /* 表示点击分页数按钮调用的方法 */                  
			});
			$("#userinfoList tr").each(function(i){
				if(i>0){
					$(this).bind("click",function(){
						var companyId = $(this).find("td").first().text();
						 window.location.href="companyinfo.do?companyId="+companyId;
					});
				}
			});
		});
		
PageClick = function(pageclickednumber) {
	$("#pager").pager({
	    pagenumber:pageclickednumber,                 /* 表示启示页 */
	    pagecount:'${userCompany.pageCount}',                  /* 表示最大页数pagecount */
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
	userCompanyForm.submit();
}
function showdialog(){
	var wz = getDialogPosition($('#companyInfoWindow').get(0),100);
	$('#companyInfoWindow').window({
		  	top: 100,
		    left: wz[1],
		    onBeforeClose: function () {
		    }
	});
	$('#companyInfoWindow').window('open');
}
function saveCompany(obj){
	if ($('#saveCompanyForm').form('validate')) {
		$(obj).attr("onclick", ""); 
		 $('#saveCompanyForm').form('submit',{
		  		success:function(data){
		  			data = $.parseJSON(data);
		  			if(data.code==0){
		  				$.messager.alert('保存信息',data.message,'info',function(){
		  					$('#companyInfoWindow').window('close');
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
				<i class="yw-icon icon-partner"></i><span>公司列表</span>
			</div>
		</div>
		<div class="fl yw-lump mt10">
			<form id="userCompanyForm" name="userCompanyForm"
				action="userinfo.do" method="get">
				<div class="pd10-28">
					<div class="fl">
						<!-- <button class="yw-btn bg-blue cur">全部客户</button> -->
						<!-- <button class="yw-btn bg-gray ml20 cur">满意度调查</button> -->
					</div>
					<div class="fr">
						<input type="text" name="searchName" class="yw-input wid170"
							placeholder="搜索" value="${userCompany.searchName}" />
						<!-- <button class="yw-btn bg-orange ml30 cur" type="submit" onclick="search();">开始查找</button> -->
						<!-- <button class="yw-btn bg-green ml20 cur" onclick="showdialog();">新建公司</button> -->
						<span class="yw-btn bg-orange ml30 cur" onclick="search();">开始查找</span>
						<span class="yw-btn bg-green ml20 cur" onclick="showdialog();">新建公司</span>
					</div>
					<div class="cl"></div>
				</div>

				<input type="hidden" id="pageNumber" name="pageNo"
					value="${userCompany.pageNo}" />
			</form>
		</div>
		<div class="fl">
			<div class="fl yw-lump wid250 mt10">
				<div class="yw-cm-title">
					<span class="ml26">机构列表</span>
				</div>
				<div class="yw-tree-list" id="treeList" style="height: 639px;">机构树列表</div>
			</div>
			<div class="yw-lump wid-atuo ml260 mt10">
				<div class="yw-cm-title">
					<span class="ml26">全部公司</span>
				</div>
				<table class="yw-cm-table" id="userinfoList">
					<tr>
						<th width="4%">ID</th>
						<th>公司名称</th>
						<th>联系人</th> 
					</tr>
					<c:forEach var="item" items="${userCompanylist}">
						<tr>
							<td align="center">${item.id}</td>
							<td>${item.name}</td>
							<td>${item.userNum}位</td>
						</tr>
					</c:forEach>
				</table>
				<div class="page" id="pager"></div>
			</div>
		</div>
 	  <div id="companyInfoWindow" class="easyui-window" title="新添加公司" style="width:560px;height:460px;overflow:hidden;padding:10px;" iconCls="icon-info" closed="true" modal="true"   resizable="false" collapsible="false" minimizable="false" maximizable="false">
		<form id="saveCompanyForm" name ="saveCompanyForm" action="saveOrupdateCompany.do"  method="post">
		<p style="display:none">
        	<span class="fl">id：</span><input name="id" type="text" value="0" class="easyui-validatebox"/>
        </p>
		<p class="yw-window-p">
        	<span class="fl">公司名称：</span><input name="name" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
		<p class="yw-window-p">
        	<span class="fl">公司编码：</span><input name="serialCode" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">上级机构：</span><input  name="vvvvv" class="easyui-combotree"   url="loadCustomerCompanyParent.do?parentId=146" style="width:254px;height:30px;" value="" data-options="valueField:'id',textField:'text'"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">所在区域：</span><input name="district" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">联系地址：</span><input name="address" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">邮政编码：</span><input name="code" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,6]" style="width:254px;height:30px;"/>
        </p>
        <div class="yw-window-footer txt-right">
        	<span class="yw-window-btn bg-lightgray mt12"  onclick="$('#companyInfoWindow').window('close');">退出</span>
        	<span class="yw-window-btn bg-blue mt12" onclick="saveCompany(this);">保存</span>
        </div>
        </form>
	</div>
</body>
</html>
