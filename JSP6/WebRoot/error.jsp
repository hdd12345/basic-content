<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- <meta http-equiv="refresh" content="3;login.jsp"> -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	

  </head>
  
  <body background="images/jianyue.jpg">
    <p align="center" style="padding-top: 300px">
    	您还没登录呢！将在
    	<span id="piguye" style="color: red">3</span>
    	秒后回到登录界面！
    </p>
  </body>
  <script type="text/javascript">
  	var num=2;
  	setTimeout(function tz(){
  		window.location.href="http://localhost:8080/JSP6/login.jsp";
  	}, 3000);
  	var y = setInterval(function() {
  		document.getElementById("piguye").innerHTML=num;
  		if(num==1){
  			clearInterval(y);
  		}
  		num--;
  	}, 1000);
  	
  </script>
  
</html>
