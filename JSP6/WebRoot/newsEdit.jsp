<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hdd.util.*" %>
<%@ page import="com.hdd.entity.*" %>
<%@page import="com.hdd.service.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newsUpdate.jsp' starting page</title>
    
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
  
  <body background="images/jianyue.jpg">
  	<%
  		String Id=request.getParameter("id");
  		int id=0;
  		if(Id!=null){
  			id = Integer.parseInt(Id);
  		}
  		News news=NewsService.selectById(id); %>
  	<div align="center" >
  		<form id="form1" action="com.hdd.servlet/UpdateServlet" method="post">
  		<input type="hidden" name="id" value="<%=id%>">
  		新闻标题:<br/>
  		<input type="text"  id="title"  name="title" value="<%=news.getTitle()%>" size="100" style="background: none;"><br/><br>
  		新闻内容：<br/>
  		<textarea id="content" name="content" rows="20" cols="82" style="background: none;"><%=news.getContent() %></textarea><br><br>
  		<input type="submit" id="sb" value="修改" onclick="return checkEmpty()">
  		</form>
  	</div>
  	<% if(Id == null) { %>
  		<script type="text/javascript">
  		document.getElementById("form1").setAttribute("action", "com.hdd.servlet/AddServlet");
  		document.getElementById("sb").value="添加";
  		</script>
  	<%} %>
  	
  	<script type="text/javascript">
  		function checkEmpty(){
  			var title = document.getElementById("title");
  			var content = document.getElementById("content");
  			if(""==title.value||""==content.value){
  				alert("新闻标题和内容不能为空！");
  				return false;
  			}
  			return true;
  		}
  	</script>
  	
  </body>
</html>
