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
<title>员工信息</title>
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
		$("#tab1 input[type='checkbox']").attr("disabled","disabled");
		if($("#tab1 input[type='radio']").val()==1){
			$('#projectModel').attr('style','display:none');$('#systemModel').removeAttr('style');
		}else if($("#tab1 input[type='radio']").val()==3){
			$('#systemModel').attr('style','display:none');$('#projectModel').removeAttr('style');
		}
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
		$("#tab1 input[type='checkbox']").removeAttr("disabled");
		//if($("#tab1 input[type='radio']").val()==1){
		//	$('#projectModel').attr('style','display:none');$('#systemModel').removeAttr('style');
		//}else if($("#tab1 input[type='radio']").val()==3){
		//	$('#systemModel').attr('style','display:none');$('#projectModel').removeAttr('style');
		//}
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
				<i class="yw-icon icon-back" onclick="window.location.href='userList.do?companyId=${userinfo.companyId}'"></i><span>员工：${userinfo.name}</span>
			</div>
		</div>

		<div class="fl yw-lump mt10">
			<div class="yw-bi-rows">
				<div class="yw-bi-tabs mt5" id="ywTabs">
					<span class="yw-bi-now">员工详情</span>
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
								<input id="userName" name="name" type="text" value="${userinfo.name}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /> 
								<input name="id" type="hidden" value="${userinfo.id}" /> 
								<input name="companyId" type="hidden" value="${userinfo.companyId}" /></td>
						</tr>
						<tr>
							<td width="10%" align="center">性别：</td>
							<td>
								<select id="sex" name="sex" style="width:254px;height:30px;" class="easyui-combobox">
								 	 <c:if test="${userinfo.sex == 0 }">
								 	 	<option  value="-1">=请选择性别=</option><option selected="selected" value="0">男</option><option value="1">女</option>
								 	 </c:if>  
								 	 <c:if test="${userinfo.sex == 1 }">
								 	 	<option  value="-1">=请选择性别=</option><option value="0">男</option><option selected="selected" value="1">女</option>
								 	 </c:if>   
								</select>
							</td>
						</tr>
						<tr>
							<td align="center">联系电话：</td>
							<td><input id="phone" name="phone" type="text" value="${userinfo.phone}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /></td>
						</tr>
						<tr>
							<td align="center">邮箱：</td>
							<td><input id="email"  name="email" type="text" value="${userinfo.email}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /></td>
						</tr>
						<tr>
							<td align="center">所在岗位：</td>
							<td><input id="post" name="post" type="text" value="${userinfo.post}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:254px;height:30px;" /></td>
						</tr>
						<tr>
							<td align="center">角色：</td>
							<td>
								 <c:if test="${userinfo.roleKey == 1 }">
									<label><input id="roleKey1" type="radio" name="roleKey" checked="checked" value="1" onclick="$('#projectModel').attr('style','display:none');$('#systemModel').removeAttr('style');//$('#projectModel input[type=\'checkbox\']').attr('checked',false);" />服务台</label>
									<label><input id="roleKey2" type="radio" name="roleKey" value="2" onclick="//$('#projectModel input[type=\'checkbox\']').attr('checked',false);$('#systemModel input[type=\'checkbox\']').attr('checked',false);" />专家</label>
									<label><input id="roleKey3" type="radio" name="roleKey" value="3" onclick="$('#systemModel').attr('style','display:none');$('#projectModel').removeAttr('style');//$('#systemModel input[type=\'checkbox\']').attr('checked',false);" />维护人员</label>
								 </c:if>
								 <c:if test="${userinfo.roleKey == 2 }">
									<label><input id="roleKey1" type="radio" name="roleKey" value="1" onclick="$('#projectModel').attr('style','display:none');$('#systemModel').removeAttr('style');$('#projectModel input[type=\'checkbox\']').attr('checked',false);" />服务台</label>
									<label><input id="roleKey2" type="radio" name="roleKey" checked="checked" value="2" onclick="//$('#projectModel input[type=\'checkbox\']').attr('checked',false);$('#systemModel input[type=\'checkbox\']').attr('checked',false);" />专家</label>
									<label><input id="roleKey3" type="radio" name="roleKey" value="3" onclick="$('#systemModel').attr('style','display:none');$('#projectModel').removeAttr('style');$('#systemModel input[type=\'checkbox\']').attr('checked',false);" />维护人员</label>
								 </c:if>
								 <c:if test="${userinfo.roleKey == 3 }">
									<label><input id="roleKey1" type="radio" name="roleKey" value="1" onclick="$('#projectModel').attr('style','display:none');$('#systemModel').removeAttr('style');//$('#projectModel input[type=\'checkbox\']').attr('checked',false);" />服务台</label>
									<label><input id="roleKey2" type="radio" name="roleKey" value="2" onclick="//$('#projectModel input[type=\'checkbox\']').attr('checked',false);$('#systemModel input[type=\'checkbox\']').attr('checked',false);" />专家</label>
									<label><input id="roleKey3" type="radio" name="roleKey" checked="checked" value="3" onclick="$('#systemModel').attr('style','display:none');$('#projectModel').removeAttr('style');//$('#systemModel input[type=\'checkbox\']').attr('checked',false);" />维护人员</label>
								 </c:if>
							</td>
						</tr> 
						<tr  id="projectModel">
							<td align="center">工种类别：</td>
							<td>
        						<p class="yw-window-p">
        						<c:choose>
        							<c:when test="${userinfo.userTypeList != null }">
		        						<c:forEach var="item" items="${userinfo.userTypeList}">
		        							<c:choose>
												<c:when test="${item == 1}">
													<input type="checkbox" name="userTypeList" checked="checked" value="1">电源　 
												</c:when> 
												<c:when test="${item == 2}"> 
													<input type="checkbox" name="userTypeList" checked="checked" value="2">平台 
												</c:when> 
												<c:when test="${item == 3}"> 
													<input type="checkbox" name="userTypeList" checked="checked" value="3">前端　
												</c:when>
												<c:otherwise>
													<input type="checkbox" name="userTypeList" value="1">电源　
													<input type="checkbox" name="userTypeList" value="2">平台
													<input type="checkbox" name="userTypeList" value="3">前端　
												</c:otherwise> 
											</c:choose>
		        						</c:forEach> 
		        					</c:when>
									<c:otherwise>
										<input type="checkbox" name="userTypeList" value="1">电源　
										<input type="checkbox" name="userTypeList" value="2">平台
										<input type="checkbox" name="userTypeList" value="3">前端　
									</c:otherwise> 
	        					</c:choose>
        						</p>
							</td>
						</tr> 
						<tr id="systemModel">
							<td align="center">功能模块：</td>
							<td>
								<p class="yw-window-p">
								
        						<c:choose>
        							<c:when test="${userinfo.userFunList != null }">
		        						<c:forEach var="funitem" items="${userinfo.userFunList}">
		        							<c:choose>
												<c:when test="${funitem == 1}">
													<input type="checkbox" name="userFunList" checked="checked" value="1">个人工作台　 
												</c:when> 
												<c:when test="${funitem == 2}"> 
													<input type="checkbox" name="userFunList" checked="checked" value="2">客户管理 
												</c:when> 
												<c:when test="${funitem == 3}"> 
													<input type="checkbox" name="userFunList" checked="checked" value="3">员工管理 
												</c:when>
												<c:when test="${funitem == 4}"> 
													<input type="checkbox" name="userFunList" checked="checked" value="4">项目管理
												</c:when>
												<c:otherwise>
										        	<input type="checkbox" name="userFunList"  value="1">个人工作台　　
													<input type="checkbox" name="userFunList"  value="2">客户管理
													<input type="checkbox" name="userFunList"  value="3">员工管理
													<input type="checkbox" name="userFunList"  value="4">项目管理
												</c:otherwise> 
											</c:choose>
		        						</c:forEach> 
		        					</c:when>
									<c:otherwise>
							        	<input type="checkbox" name="userFunList"  value="1">个人工作台　　
										<input type="checkbox" name="userFunList"  value="2">客户管理
										<input type="checkbox" name="userFunList"  value="3">员工管理
										<input type="checkbox" name="userFunList"  value="4">项目管理
									</c:otherwise> 
	        					</c:choose>
								</p>
							</td>
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
