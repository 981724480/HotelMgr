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

</script>
  </head>
  
  <body>
	
        <div id="content">
            <div class="con-right" id="conRight">
            	<div class="fl yw-lump">
                	<div class="yw-lump-title">
                    	<i class="yw-icon icon-back"></i><span>故障单 INC-20151103-0003-TY</span>
                         <div class="fr">
                            <button class="yw-btn bg-yellow mt10 mr26"><i class="fl yw-icon icon-print mt2"></i>打印</button>
                        </div>
                    </div>
                </div>
               	<div class="fl yw-lump mt10">
                	<div class="yw-cm-title">
                    	<span class="ml26">当前工作： INC-20151103-0003-TY 已请验</span><button class="yw-btn bg-orange ml40">执行本工作</button>
                        <div class="fr mr26">
                        	<span>执行人：<span class="color-orange">张少华</span> | 剩余00:59:00</span>
                        </div>
                    </div>
                    <div class="fl wid80-percent">
                    	<div class="pd10-28">
                        	<table class="yw-table">
                            	<tr>
                                	<td colspan="2">点位名称：九兴大道10号泰山科技大厦点位A10号</td><td>故障现象：视频图像模糊</td>
                                </tr>
                                <tr>
                                	<td>影响程度：严重</td><td>项目：公共天网</td><td>故障类型：前端点位</td>
                                </tr>
                                <tr>
                                	<td colspan="2">点位编码：2012457210364101785268</td><td>IP地址：192.168.133.22</td>
                                </tr>
                                <tr>
                                	<td colspan="3">故障描述：九兴大道10号泰山科技大厦A10号点位，视频图像模糊</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="fr wid20-percent">
                    	<div class="yw-fi-flag"><img src="../../images/yw-icon1.png"/></div>
                    </div>
                </div>
                <div class="fl yw-lump mt10">
                	<div class="yw-cm-title">
                    	<span class="ml26">流水信息</span>
                    </div>
                    <table class="yw-fi-table">
                    	<tr>
                        	<th width="180">工单类型</th><th>开始时间</th><th>执行者</th><th>完成时间</th><th>工单说明</th>
                        </tr>
                        <tr>
                        	<td align="center"><i class="fl yw-icon icon-dot1 mt20 ml60"></i><span class="fl ml10">申告</span></td><td align="center">2015-11-03 16:18:01</td>
                            <td align="center">支撑-天翼公司/全球眼网管中心/监控维护中心/陈某某</td><td align="center">2015-11-03 16:24:40</td><td align="center">申告</td>
                        </tr>
                        <tr>
                        	<td align="center"><i class="fl yw-icon icon-dot1 mt20 ml60"></i><span class="fl ml10">派单</span></td><td align="center">2015-11-03 16:18:01</td>
                            <td align="center">支撑-天翼公司/全球眼网管中心/监控维护中心/陈某某</td><td align="center">2015-11-03 16:24:40</td><td align="center">根据省集约化政企包区规划</td>
                        </tr>
                        <tr>
                        	<td align="center"><i class="fl yw-icon icon-dot2 mt20 ml60"></i><span class="fl ml10">回单</span></td><td align="center">2015-11-03 16:18:01</td>
                            <td align="center">支撑-天翼公司/全球眼网管中心/监控维护中心/陈某某</td><td align="center">2015-11-03 16:24:40</td><td align="center">根据现场查看，确定摄像头电源故障，需现场解决</td>
                        </tr>
                    </table>
                </div>
                
                <div class="cl"></div>
            </div>
            <div class="cl"></div>
        </div>
    </div>
</body>
</html>

