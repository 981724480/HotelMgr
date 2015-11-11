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
<title>联系人信息</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1  ,maximum-scale=1, user-scalable=no" /> 
<script type="text/javascript">
	$(document).ready(function() {
		setShowStates();
		
	});   
	function setShowStates(){
		$("#userName").attr("readonly","readonly");
		$("#sex").combobox("disable",true);
		$("#phone").attr("readonly","readonly");
		$("#email").attr("readonly","readonly");
		$("#post").attr("readonly","readonly");
		$("#tab1 input[type='radio']").attr("disabled","disabled");  
		$("#editBtn").show();
		$("#saveBtn").hide();
	};
	function editUser(){
		$("#userName").removeAttr("readonly");
		$("#sex").combobox("enable",true);
		$("#phone").removeAttr("readonly");
		$("#email").removeAttr("readonly");
		$("#post").removeAttr("readonly");
		$("#tab1 input[type='radio']").removeAttr("disabled"); 
		$("#editBtn").hide();
		$("#saveBtn").show();
	};
	function saveUser(obj) {
		if ($('#userForm').form('validate')) {
			$(obj).attr("onclick", "");
			$('#userForm').form(
					'submit',
					{
						success : function(data) {
							data = $.parseJSON(data);
							if (data.code == 0) {
								$.messager.alert('保存信息', data.message, 'info',
										function() {  
											setShowStates();
										});
							} else {
								$.messager.alert('错误信息', data.message, 'error',
										function() {
											$(obj).attr("onclick",
													"saveUser(this);");
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
				<i class="yw-icon icon-back" onclick="window.location.href='customerUserList.do?customerId=${customeruser.clientCompanyId}'"></i><span>联系人：${customeruser.name}</span>
			</div>
		</div>

		<div class="fl yw-lump mt10">
			<div class="yw-bi-rows">
				<div class="yw-bi-tabs mt5" id="ywTabs">
					<span class="yw-bi-now">联系人详情</span>
				</div>
				<div class="fr mt10">
					<span class="yw-btn bg-green mr26" id="editBtn" onclick="editUser();">编辑</span> 
					<span class="yw-btn bg-red mr26" id="saveBtn" onclick="saveUser(this);">保存</span>
				</div>
			</div>
			<div id="tab1" class="yw-tab">
				<form id="userForm" name="userForm"
					action="saveOrupdateUser.do" method="post">
					<table class="yw-cm-table font16">
						<tr>
							<td width="10%" align="center">员工姓名：</td>
							<td>
								<input id="userName" name="name" type="text" value="${customeruser.name}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /> 
								<input name="id" type="hidden" value="${customeruser.id}" /> 
								<input name="companyId" type="hidden" value="${customeruser.clientCompanyId}" /></td>
						</tr>
						<tr>
							<td width="10%" align="center">性别：</td>
							<td>
								<select id="sex" name="sex" style="width:254px;height:30px;" class="easyui-combobox">
								 	 <c:if test="${customeruser.sex == 0 }">
								 	 	<option  value="-1">=请选择性别=</option><option selected="selected" value="0">男</option><option value="1">女</option>
								 	 </c:if>  
								 	 <c:if test="${customeruser.sex == 1 }">
								 	 	<option  value="-1">=请选择性别=</option><option value="0">男</option><option selected="selected" value="1">女</option>
								 	 </c:if>   
								</select>
							</td>
						</tr>
						<tr>
							<td align="center">联系电话：</td>
							<td><input id="phone" name="phone" type="text" value="${customeruser.phone}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /></td>
						</tr>
						<tr>
							<td align="center">邮箱：</td>
							<td><input id="email"  name="email" type="text" value="${customeruser.email}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /></td>
						</tr>
						<tr>
							<td align="center">所在岗位：</td>
							<td><input id="post" name="post" type="text" value="${customeruser.post}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /></td>
						</tr>
						<tr>
							<td align="center">允许登陆：</td>
							<td>
								 <c:if test="">
									<label><input type="radio" name="allowLogin" checked="checked" value="1"  />微展厅</label>
									<label><input type="radio" name="allowLogin" value="2"  />尊享服务</label>
									<label><input type="radio" name="allowLogin" value="3" />专属信息</label>
								 </c:if>
								 <c:if test="">
									<label><input type="radio" name="allowLogin" value="1"  />微展厅</label>
									<label><input type="radio" name="allowLogin" checked="checked"  value="2"  />尊享服务</label>
									<label><input type="radio" name="allowLogin" value="3" />专属信息</label></c:if>
								 <c:if test="">
									<label><input type="radio" name="allowLogin" value="1"  />微展厅</label>
									<label><input type="radio" name="allowLogin" value="2"  />尊享服务</label>
									<label><input type="radio" name="allowLogin" checked="checked" value="3" />专属信息</label></c:if>
							</td>
						</tr> 
						<tr>
							<td align="center">是否微博绑定：<label id="isbindWeiBo"></label></td>
							<td align="left">绑定时间：<label id="bindTime"></label></td>
						</tr> 
						<tr>
							<td align="left" colspan="2"><span class="ml20">首次登陆时间：<label id="firstloginTime">${customeruser.firstTime}</label></span> <span class="ml10">末次登陆时间：<label id="endLoginTime"></label></span></td>
							 
						</tr> 
					</table>
				</form>
			</div>
		</div>
		<div class="cl"></div>
	</div>
	<div class="cl"></div>

	</div>

</body>
</html>
