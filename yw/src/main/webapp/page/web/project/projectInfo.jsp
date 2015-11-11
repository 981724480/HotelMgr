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
		//$("#userName").attr("readonly","readonly");  
		$("#editBtn").show();
		$("#saveBtn").hide();
	};
	function editProject(){
		//$("#userName").removeAttr("readonly");  
		$("#editBtn").hide();
		$("#saveBtn").show();
	};
	function saveProject(obj) {
		if ($('#projectForm').form('validate')) {
			$(obj).attr("onclick", "");
			$('#projectForm').form(
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
													"saveProject(this);");
										});
							}
						}
					});
		}
	} 
	function addPoint(){
		var wz = getDialogPosition($('#pointInfoWindow').get(0),100);
		$('#pointInfoWindow').window({
			  	top: 100,
			    left: wz[1],
			    onBeforeClose: function () {
			    }
		});
		$('#pointInfoWindow').window('open');
	};
	function importPointBtn(obj){
	};
</script>
</head>

<body>
	<div class="con-right" id="conRight">
		<div class="fl yw-lump">
			<div class="yw-lump-title">
				<i class="yw-icon icon-back" onclick="window.location.href='projectList.do'"></i><span>${project.id == 0 ? "新建项目":("项目：" + project.name)}</span>
			</div>
		</div>

		<div class="fl yw-lump mt10">
			<div class="yw-bi-rows">
				<div class="yw-bi-tabs mt5" id="ywTabs">
					<span class="yw-bi-now">基本信息</span>
				</div>
				<div class="fr mt10">
					<span class="yw-btn bg-green mr26" id="editBtn" onclick="editProject();">编辑</span> 
					<span class="yw-btn bg-red mr26" id="saveBtn" onclick="saveProject(this);">保存</span>
				</div>
			</div>
			<div id="tab1" class="yw-tab">
				<form id="projectForm" name="projectForm"
					action="saveOrupdateProject.do" method="post">
					<table class="yw-cm-table font16">
						<tr>
							<td width="8%" align="right">项目编号：</td>
							<td>
								<input id="projectNumber" name="projectNumber" type="text" value="${project.projectNumber}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:90%;height:30px;" /> 
								<input name="id" type="hidden" value="${project.id}" /> 
							</td>
							<td width="8%" align="right" >项目名称：</td>
							<td colspan="3"><input id="name" name="name" type="text" value="${project.name}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:77.2%;height:30px;" /></td>
						</tr> 
						<tr>
							<td align="right">项目所在地：</td>
							<td><input id="district" name="district" type="text" value="${project.district}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:90%;height:30px;" /></td>
							<td align="right">维护开始时间：</td>
							<td  colspan="3">
								<input id="startDate" name="startDate" type="text" value="${project.startDate}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:30%;height:30px;" />
								<span class="ml50">维护结束时间：</span>
								<input id="endDate" name="endDate" type="text" value="${project.startDate}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:30.3%;height:30px;" />
							</td> 
						</tr>
						<tr>
							<td align="right">所属行业：</td>
							<td><input id="industryKey"  name="industryKey" type="text" value="${project.industryKey}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:90%;height:30px;" /></td>
							<td align="right">客户经理：</td>
							<td  colspan="3">
								<input id="clientManager"  name="clientManager" type="text" value="${project.clientManager}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:30%;height:30px;" />
								<span class="ml82">合同金额：</span>
								<input id="contractNum"  name="contractNum" type="text" value="${project.contractNum}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:30.3%;height:30px;" /></td>						
						</tr>
						<tr>
							<td align="right">维护公司名称：</td>
							<td colspan="5"><input id="maintainCompanyName" name="maintainCompanyName" type="text" value="${project.maintainCompanyName}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:84.2%;height:30px;" /></td>
						</tr>
						<tr>
							<td align="right">维护合同编号：</td>
							<td colspan="5"><input id="maintainContract" name="maintainContract" type="text" value="${project.maintainContract}" class="easyui-validatebox" required="true" validType="Length[1,25]" style="width:84.2%;height:30px;" /></td>
						</tr>   
					</table>
				</form>
			</div>
			<div class="yw-bi-rows">
				<div class="yw-bi-tabs mt5" id="ywTabs">
					<span class="yw-bi-now">点位信息</span>
				</div>
				<div class="fr mt10">
					<span class="yw-btn bg-green mr26" id="AddPointBtn" onclick="addPoint();">新增</span> 
					<span class="yw-btn bg-red mr26" id="importPointBtn" onclick="importPointBtn(this);">导入点位信息</span>
				</div>
			</div>
			<div id="tab2" class="yw-tab"> 
				<table class="yw-cm-table" id="pointlist" style="max-height:630px;">
					<tr style="height:30px">
						<th>序号</th>
						<th>点位ID</th> 
						<th>点位IP</th>
						<th>点位编号</th>
						<th>点位名称</th>
						<th>点位类型</th>
						<th>点位地址</th> 
						<th>GPS</th> 
					</tr>
					<c:forEach var="item" items="${pointlist}">
						<tr style="height:30px">
							<td align="left">${item.id}</td>
							<td>${item.pointId}</td> 
							<td>${item.ipAddress}</td> 
							<td>${item.pointNumber}</td> 
							<td>${item.name}</td> 
							<td>${item.type}</td> 
							<td>${item.address}</td> 
							<td>${item.locationX+","+item.locationY}</td> 
						</tr>
					</c:forEach>
				</table> 
			</div>
		</div>
		<div class="cl"></div>
	</div>
	<div class="cl"></div>
	</div>
	
 	  <div id="pointInfoWindow" class="easyui-window" title="新添点位" style="width:560px;height:500px;overflow:hidden;padding:10px;" iconCls="icon-info" closed="true" modal="true"   resizable="false" collapsible="false" minimizable="false" maximizable="false">
		<form id="savePointForm" name ="savePointForm" action="saveOrupdatePoint.do"  method="post">
		<p style="display:none">
        	<span class="fl">id：</span><input name="id" type="text" value="0" class="easyui-validatebox"/>
        	<span class="fl">projectId：</span><input name="projectId" type="text" value="${project.id}" class="easyui-validatebox"/>
        </p>
		<p class="yw-window-p">
        	<span class="fl">点位ID：</span><input name="pointId" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p> 
		<p class="yw-window-p">
        	<span class="fl">点位IP：</span><input name="ipAddress" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">点位编码：</span><input name="pointNumber" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">点位名称：</span><input name="name" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">点位类型：</span><input name="type" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p>
        <p class="yw-window-p">
        	<span class="fl">点位地址：</span><input name="address" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p> 
        <p class="yw-window-p">
        	<span class="fl">GPS—X：</span><input name="locationX" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p> 
        <p class="yw-window-p">
        	<span class="fl">GPS—Y：</span><input name="locationY" type="text" value="" class="easyui-validatebox" required="true"  validType="Length[1,25]" style="width:254px;height:30px;"/>
        </p> 
        <div class="yw-window-footer txt-right">
        	<span class="yw-window-btn bg-lightgray mt12"  onclick="$('#pointInfoWindow').window('close');">退出</span>
        	<span class="yw-window-btn bg-blue mt12" onclick="savePoint(this);">保存</span>
        </div>
        </form>
	</div>
</body>
</html>
