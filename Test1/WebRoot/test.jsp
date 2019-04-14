<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/test.css">
	<script type="text/javascript" src="jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#username").blur(function(){
				if(this.value.length==""){
					$(this).next().data({"count":0});
					$(this).next().show();
				}else{
					$(this).next().data({"count":1});
					$(this).next().hide();
				}
			});
			$("#password").blur(function(){
				if(this.value.length<6){
					$(this).next().data({"count":0});
					$(this).next().show();
				}else{
					$(this).next().data({"count":1});
					$(this).next().hide();
				}
			});
			$("#repassword").blur(function(){
				if(this.value!=$("#password").val()){
					$(this).next().data({"count":0});
					$(this).next().show();
				}else{
					$(this).next().data({"count":1});
					$(this).next().hide();
				}
			});
			$("form").submit(function(){
				var total = 0;
				$(".error").each(function(){
					total+=$(this).data("count");
				});
				if(total=3){
					return false;
				}
			});
		});
	</script>
  </head>
  
  <body>
    <form action="" method="post">
    	<div align="center">
	    		用户名：
	    		<input type="text" id="username" >
	    		<span class="error" >用户名不能为空！</span><br><br>
	    		密码：
	    		<input type="password" id="password">
	    		<span class="error">密码不能少于六位！</span><br><br>
	    		确认密码：
	    		<input type="password" id="repassword">
	    		<span class="error">两次密码不一样！</span><br><br>
    			<input type="submit" name="submit" class="btn" value="注册">
    	</div>
    </form>
  </body>
</html>
