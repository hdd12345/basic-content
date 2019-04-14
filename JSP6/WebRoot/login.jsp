<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body background="images/jianyue.jpg">
  	<br/><br/><br/><br/><br/><br/><br/>
  	<p align="center" style="font-size: 30px;font-weight: bold;">新闻系统</p>
  	<form action="com.hdd.servlet/LoginServlet" method="post">
  		<table  align="center" 
  					border="2"  bordercolor="red" cellpadding="2"
  					width="30%">
  			<tr>
  				<td align="right"  width="50%">学号：</td>
  				<td align="center" width="50%"><input type="text"  name="userNo" style="background: none;"></td>
  			</tr>
  			<tr>
  				<td align="right">密码：</td>
  				<td align="center"><input type="password" name="password" style="background: none;"></td>
  			</tr>
           	<tr>
  				<td align="center" colspan="2">
  					<input type="submit" value="登录" >
  					<input type="reset" value="清空">
  				</td>
  			</tr>
  		</table>
  	</form><br/>

  </body>
</html>
