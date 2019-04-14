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
	<link rel="stylesheet" type="text/css" href="css/test.css">
	<script type="text/javascript" src="jquery/jquery-3.3.1.js"></script>
	<!--  <script type="text/javascript">
		$(document).ready(function(){
		  $("body").mouseleave(function(){
		  	alert("hey");
		  });
		});
</script>-->
	<script type="text/javascript">
		$(document).ready(function(){
			var x;
			var flag;
			//start按钮监听
			$("#btn1").on("click",function(){
				flag = true;
				$("#btn1").hide();
				var intDiff = parseInt($("#minute").text()*60+$("#second"));
				x = window.setInterval(function() {
				var hour = 0;
				var minute = 0;
				var second = 0;
				if(intDiff>0){
					hour = Math.floor(intDiff/(60*60));
					minute = Math.floor(intDiff/(60))-hour*60;
					second = intDiff-hour*60*60-minute*60;	
				}
				if(hour<=9){hour='0'+hour};
				if(minute<=9){minute='0'+minute};
				if(second<=9){second='0'+second};
				$("#hour").html(hour);
				$("#minute").html(minute);
				$("#second").html(second);
				if(intDiff==0){
					clearInterval(x)
					flag = false;
					alert("计时完成！");
				}
				intDiff--;
			},1000);
			});
			//stop按钮监听
			$("#btn2").on("click",function(){
				if(flag){
					if(confirm("确定要终止吗？")){
					clearInterval(x);
					$("#btn1").show();
					$("#hour").html("00");
					$("#minute").html("10");
					$("#second").html("00");
					flag = false;
					}
				}
			});
			//鼠标移出窗口监听
			$(document).mouseleave(function(){
				if(flag){
					if(confirm("确定要终止吗？")){
					clearInterval(x);
					$("#hour").html("00");
					$("#minute").html("10");
					$("#second").html("00");
					flag = false;
					}
				}
			});
		});
	</script>
  </head>
  
  <body>
    <p align="center">
    	<span id="hour">00</span>:<span id="minute">10</span>:<span id="second">00</span><br>
    	<button id="btn1" class="btn">start</button>
    	<button id="btn2" class="btn">stop</button>
    	<span id="ff"></span>
    </p>
   
  </body>
</html>
