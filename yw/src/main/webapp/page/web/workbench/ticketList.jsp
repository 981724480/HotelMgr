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
	$(function(){
		//计算网页高度
		setHei();
		$(window).resize(function(){
			setHei();
		});
	});
	
	function setHei(){
		var h = $(window).height();
		var t = $("#content").offset().top;
		var v = h-t-1;
		var rh = $("#conRight").height();
		if(rh>v){
			v = rh+20;
		}
		$("#content").css("height",v);
	}
</script>
</head>

<body>
	
        <div id="content">
            <div class="con-right" id="conRight">
            	<div class="fl yw-lump">
                	<div class="pd18">
                    	<div class="yw-process">
                        	<ul>
                            	<li>
                                	<div class="step1 step-now">
                                    	<div class="step-left">
                                        	<span><i class="yw-icon yw-step1-icon"></i></span>
                                        </div>
                                        <div class="step-right">
                                        	<p class="sr-num">3</p>
                                            <p class="sr-txt">待审流程</p>
                                            <em></em>
                                        </div>
                                    </div>
                                </li>
                                
                                <li>
                                	<div class="step2">
                                    	<div class="step-left">
                                        	<span><i class="yw-icon yw-step2-icon"></i></span>
                                        </div>
                                        <div class="step-right">
                                        	<p class="sr-num">0</p>
                                            <p class="sr-txt">业务受理</p>
                                            <em></em>
                                        </div>
                                    </div>
                                </li>
                                
                                <li>
                                	<div class="step3">
                                    	<div class="step-left">
                                        	<span><i class="yw-icon yw-step3-icon"></i></span>
                                        </div>
                                        <div class="step-right">
                                        	<p class="sr-num">1</p>
                                            <p class="sr-txt">预警工单</p>
                                            <em></em>
                                        </div>
                                    </div>
                                </li>
                                
                                <li>
                                	<div class="step4">
                                    	<div class="step-left">
                                        	<span><i class="yw-icon yw-step4-icon"></i></span>
                                        </div>
                                        <div class="step-right">
                                        	<p class="sr-num">1</p>
                                            <p class="sr-txt">最新汇报</p>
                                            <em></em>
                                        </div>
                                    </div>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="fl yw-lump mt20">
                	<div class="yw-info-left">
                    	<ul>
                        	<li class="yw-it-tab">
                        		<span>待验证（2）</span><em></em>
                        	</li>
                        	<li>
                        		<span>挂单审核（1）</span><em></em>
                       		</li>
                        	<li>
                        		<span>退单审核（0）</span><em></em>
                        	</li>
                    	</ul>
                    </div>
                    <div class="yw-info-right">
                    	<table class="yw-info-table">
                        	<tr>
                            	<td class="no-border" valign="bottom" width="60%">INC-20151030-0001-TY 九兴大道10号泰山科技大厦点位A10号</td>
                                <td rowspan="2" align="center"><a href="#">待请验</a></td>
                                <td rowspan="2" align="center"><button class="yw-it-btn">开始处理</button></td>
                            </tr>
                            <tr>
                            	<td valign="top"><em class="fl">需求发起人：锦荣公司-黄森林 10月30日</em><em class="fr mr10">10-30 09:39:56</em></td>
                            </tr>
                            
                            <tr>
                            	<td class="no-border" valign="bottom" width="60%">INC-20151030-0001-TY 九兴大道10号泰山科技大厦点位A10号</td>
                                <td rowspan="2" align="center"><a href="#">待请验</a></td>
                                <td rowspan="2" align="center"><button class="yw-it-btn">开始处理</button></td>
                            </tr>
                            <tr>
                            	<td valign="top"><em class="fl">需求发起人：锦荣公司-黄森林 10月30日</em><em class="fr mr10">10-30 09:39:56</em></td>
                            </tr>
                            
                            <tr>
                            	<td class="no-border" valign="bottom" width="60%">INC-20151030-0001-TY 九兴大道10号泰山科技大厦点位A10号</td>
                                <td rowspan="2" align="center"><a href="#">待请验</a></td>
                                <td rowspan="2" align="center"><button class="yw-it-btn">开始处理</button></td>
                            </tr>
                            <tr>
                            	<td valign="top"><em class="fl">需求发起人：锦荣公司-黄森林 10月30日</em><em class="fr mr10">10-30 09:39:56</em></td>
                            </tr>
                            
                            <tr>
                            	<td class="no-border" valign="bottom" width="60%">INC-20151030-0001-TY 九兴大道10号泰山科技大厦点位A10号</td>
                                <td rowspan="2" align="center"><a href="#">待请验</a></td>
                                <td rowspan="2" align="center"><button class="yw-it-btn">开始处理</button></td>
                            </tr>
                            <tr>
                            	<td valign="top"><em class="fl">需求发起人：锦荣公司-黄森林 10月30日</em><em class="fr mr10">10-30 09:39:56</em></td>
                            </tr>
                            
                            <tr>
                            	<td class="no-border" valign="bottom" width="60%">INC-20151030-0001-TY 九兴大道10号泰山科技大厦点位A10号</td>
                                <td rowspan="2" align="center"><a href="#">待请验</a></td>
                                <td rowspan="2" align="center"><button class="yw-it-btn">开始处理</button></td>
                            </tr>
                            <tr>
                            	<td valign="top"><em class="fl">需求发起人：锦荣公司-黄森林 10月30日</em><em class="fr mr10">10-30 09:39:56</em></td>
                            </tr>
                            
                        </table>
                    </div>
                </div>
                
                <div class="cl"></div>
            </div>
            <div class="cl"></div>
        </div>
    </div>
</body>
</html>

