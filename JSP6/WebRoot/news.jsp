<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@ page import="java.sql.*" %>
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
    
    <title>My JSP 'news.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	
	<%
			User user = (User)session.getAttribute("User");
			if(user==null){
				response.sendRedirect("error.jsp");
			}
	 %>

  </head>
  
  <body background="images/jianyue.jpg">
  <%
  	final int MAX_SIZE=NewsService.MAX_SIZE;//每页最大条数
  	int currentPage;//当前页面
  	int countPage=NewsService.countPage();//总页数
  	String currentPage1=request.getParameter("currentPage");
  	if(currentPage1==null||"0".equals(currentPage1)){
  		currentPage=1;
  	}else if(Integer.parseInt(currentPage1)>countPage){
  		currentPage=countPage;
  	}
  	 else {
  		currentPage=Integer.parseInt(currentPage1);	
  	}	
  	List<News> list=NewsService.selectCurrent(currentPage);
   %>
   	<br/>
   	<p align="center" style="font-size: 40;font-weight: bold;color: #FF0000">新闻系统</p>
  	<table align="center" border="1" bgcolor="" >
  			<tr>
  				<td>序号</td>
  				<td align="center">新闻标题</td>
  				<td>时间</td>
  				<td colspan="2">操作</td>
  			</tr>
  		<%for(int i=0;i<list.size();i++){ %>
  			<tr >
  				<td id="newsNo"><%=i+1+(currentPage-1)*MAX_SIZE %></td>
  				<td><a href="content.jsp?id=<%=list.get(i).getId()%>"><%=list.get(i).getTitle() %></a></td>
  				<td><%=list.get(i).getDate() %></td>
  				<td ><a href="com.hdd.servlet/DeleteServlet?id=<%=list.get(i).getId() %>" >删除</a></td>
  				<td ><a href="newsEdit.jsp?id=<%=list.get(i).getId()%>">修改</a></td>
  			</tr>
  		<%} %>
  		<tr>
  			<td colspan="5" align="center">
  				<span>第<%=currentPage%>页/共<%=countPage%>页</span>&nbsp;&nbsp;&nbsp;
  				<a href="news.jsp?currentPage=1" >首页</a>
  				<a href="news.jsp?currentPage=<%=currentPage-1%>" >上一页</a>
  				<a href="news.jsp?currentPage=<%=currentPage+1%>" >下一页</a>
  				<a href="news.jsp?currentPage=<%=countPage%>" >尾页</a>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="5" align="center">
  				<a href="newsEdit.jsp">添加新闻</a>
  			</td>
  		</tr>
  	</table>

  </body>
</html>
