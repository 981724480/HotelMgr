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
<title>客户管理</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1  ,maximum-scale=1, user-scalable=no" /> 
<script type="text/javascript">
		$(document).ready(function(){ 
			setShowStates();
		});   
function setShowStates(){
			$("#customerName").attr("readonly","readonly"); 
			$("#district").attr("readonly","readonly");
			$("#address").attr("readonly","readonly");	
			$("#code").attr("readonly","readonly");
			$("#typeKey").attr("readonly","readonly");
			$("#userNum").attr("readonly","readonly");
			$("#saveBtn").hide();
};  
function editCustomer(){
			$("#customerName").removeAttr("readonly"); 
			$("#district").removeAttr("readonly");
			$("#address").removeAttr("readonly");
			$("#code").removeAttr("readonly");
			$("#typeKey").removeAttr("readonly");
			$("#userNum").removeAttr("readonly");
			$("#editBtn").hide();
			$("#saveBtn").show();
};
function saveCustomer(obj){
	if ($('#customerForm').form('validate')) {
		$(obj).attr("onclick", ""); 
		 $('#customerForm').form('submit',{
		  		success:function(data){
		  			data = $.parseJSON(data);
		  			if(data.code==0){
		  				$.messager.alert('保存信息',data.message,'info',function(){ 
							setShowStates();
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
				<i class="yw-icon icon-back" onclick="window.location.href='customerinfo.do'"></i><span>客户：${customer.name}</span>
			</div>
		</div>
		<div class="fl yw-lump mt10">
			<div class="yw-bi-rows">
				<div class="yw-bi-tabs mt5" id="ywTabs">
					<span class="yw-bi-now" onclick="javaScript:void(0);">基本信息</span> <span onclick="window.location.href='customerUserList.do?customerId=${customer.id}'">联系人</span>
				</div>
				<div class="fr mt10">
					<span class="yw-btn bg-green mr26" id="editBtn"  onclick="editCustomer();">编辑</span>
					<span class="yw-btn bg-red mr26" id="saveBtn" onclick="saveCustomer(this);">保存</span>
				</div>
			</div>
			<div id="tab1" class="yw-tab">
				<form id="customerForm" name="customerForm"
						action="saveOrupdateCustomer.do" method="post">
					<table class="yw-cm-table font16">
						<tr>
							<td width="10%" align="center">客户名称：</td>
							<td><input id="customerName" name="name" type="text" value="${customer.name}" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
								<input name="id" type="hidden" value="${customer.id}" />
							</td>
						</tr> 
						<tr> 
							<td align="center">所属地区：</td>
							<td><input  id="district"  name="district" type="text" value="${customer.district}" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
						</tr>
						<tr>
							<td align="center">联系地址：</td>
							<td><input  id="address" name="address" type="text" value="${customer.address}" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
						</tr>
						<tr>
							<td align="center">邮政编码：</td>
							<td><input   id="code" name="code" type="text" value="${customer.code}" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
						</tr>
						<tr>
							<td align="center">客户类型：</td>
							<td><input  id="typeKey"  name="typeKey" type="text" value="${customer.typeKey}" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
						</tr> 
						<tr>
							<td align="center">员工数量：</td>
							<td><input  id="userNum"  name="typeKey" type="text" value="${customer.userNum}" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
						</tr> 
						<tr>
							<td align="center">维护人员：</td>
							<td><input  id="userName"  name="" type="text" readonly="readonly" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
						</tr> 
						<tr>
							<td align="center">业务员：</td>
							<td><input  id="userName1"  name="" type="text" readonly="readonly" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/></td>
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
