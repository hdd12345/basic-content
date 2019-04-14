<%@page import="com.time.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>My JSP 'main.jsp' starting page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<link rel="stylesheet" type="text/css" href="css/shop.css" />
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="js/myjs/main.js"></script>
<script src="js/common/echarts-3.0.js"></script>
<link href='https://fonts.googleapis.com/css?family=Ubuntu+Condensed'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<title>Time</title>

	<script>
	<!--读取排行-->
		$(document).ready(sortDuration());
	</script>
	<!--根据session中是否有user，来设置标签的文字-->
	<%
		User user = (User) session.getAttribute("user");
	%>
	<input id="userId" type="hidden" value="${user.uId }">
	<div id="header">
		<img alt="logo" src="images/logo.png" id="img">
		<a href="shop.jsp">积分商城</a>
		<a id="reg" href=<%=user == null ? "login.jsp" : "shop.jsp"%>><%=user == null ? "注册" : user.getCredit()+"积分"%></a> 
		<a id="login" href=<%=user == null ? "login.jsp" : "javascript:;"%>><%=user == null ? "" : user.getDuration()+"小时"%></a>
		<a id="login" href=<%=user == null ? "login.jsp" : "personal.jsp"%>><%=user == null ? "登录" : user.getuName()%></a>
	</div>

	<div id="sortdiv">
		<button onclick="sortMap()">排行柱形图</button>
		<button onclick="sortDuration()">排行列表</button>
	</div>
	<!-- 计时器，悬浮不动 -->
	<div id="right" align="center"
		style="position: fixed; top: 190px; right: 20px; width: 1000px; height: 300px; background: images/bg.jpg">
		<p id="select-box">
			<select id="select-hour">
				<option value="0">0</option>
				<option value="1" selected>1</option>
				<option value="2">2</option>
			</select> <select id="select-minute">
				<option value="00" selected>00</option>
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select> <select id="select-second">
				<option value="00" selected>00</option>
			</select>
		</p>
		<p id="vis-box">
			<span id="hour">00</span>: <span id="minute">00</span>: <span
				id="second">00</span>
		</p>
		<div style="height: 50px" display="none"></div>
		<button id="start">start</button>
		<button id="stop">stop</button>
		<span id="a"></span>
	</div>

	<div id="left" style="height: 1350px"></div>

	<!-- end main -->
	<form name="form1" method="post" action="shop.jsp"></form>
</body>
</html>
