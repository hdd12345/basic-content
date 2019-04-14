<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hdd.entity.*" %>
<%@ page import="com.hdd.service.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'content.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<% User user = (User)session.getAttribute("User");
		  if(null==user){
		  		response.sendRedirect("error.jsp");
		  } %>
	
  </head>
  
  <body background="images/jianyue.jpg" >
  	<%int id=Integer.parseInt(request.getParameter("id"));
  			String title=NewsService.selectById(id).getTitle();
  			String content=NewsService.selectById(id).getContent(); %>
  			<br/>
  			<p align="center" style="font-size: 30px;font-weight: bolder;"><%=title %></p>
  			<p style="margin-left: 20%;margin-right: 20%;font-size: 20px" ><%=content %></p>
  </body>
</html>
