<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  
  <body>
    <form action="servlet/RegisterServlet" method="post">
    	<table>
    		<tr>
    			<td>姓名：</td>
    			<td><input type="text" name="name" ></td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>
    				<input type="radio" name="sex" value="男">男
    				<input type="radio" name="sex" value="女">女
    			</td>
    		</tr>
    		<tr>
    			<td>email：</td>
    			<td><input type="text" name="email"></td>
    		</tr>
    		<tr>
    			<td>学历：</td>
    			<td>
    				<select name="education">
    					<option value="博士">博士</option>
    					<option value="硕士">硕士</option>
    					<option value="本科" selected="selected">本科</option>
    					<option value="专科">专科</option>
    					<option value="高中">高中</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>经常浏览的网站：</td>
    			<td>
    				<select name="website" multiple="true">
    					<option value="百度">百度</option>
    					<option value="网易">网易</option>
    					<option value="google" >google</option>
    					<option value="新浪">新浪</option>
    					<option value="搜狐">搜狐</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>其他信息：</td>
    			<td><textarea name="other" rows="3" cols="10"></textarea></td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<input type="submit" value="提交">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
