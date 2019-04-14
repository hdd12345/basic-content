<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="com.shop.entity.User"></jsp:useBean>
<html>
<head>
<% 
	//设置图片资源根路径
	application.setAttribute("pic_url","http://localhost:8080/pic/");%>
	<title>黄氏测试法则</title>
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript">
		function hello(){

		}
	</script>
	<script type="text/javascript">
	$("#testfor").html("123456");
 	$.ajax({
		url:"http://localhost:8080/shopping/user/showAddress",
		type:"post",
		data:"user_id=3", 
		success:function(result){
			$.each(result,function(index,item){
				var address_content = result[index].address_content;
				$("#testfor").append("<p>"+address_content+"</p>");
			});
		},
		error:function(result){
			alert("222");
		}
	}); 
	</script>
	<script type="text/javascript">
		
		$(document).ready(function(){
			$("#upload").on("click",function(){
				$.ajaxFileUpload({
					url:"http://localhost:8080/shopping/goods/upload_img",
					type:"post",
					secureuri: false,
					cache:false,
					fileElementId: "new-picture", //文件上传域的ID，这里是input的ID，而不是img的
		            dataType:"json", //返回值类型 一般设置为json
		            contentType:"application/json;charset=utf-8",
		            success:function(data){
		            	alert(data.newName);
		            	var src = "/pic/"+data.newName;
		            	$("#show-picture").attr("src",src);
		            },
		            error:function(data){
		            	alert("123");
		            	console.info(data);
		            }
				});
			});
		});
	</script>
</head>
<body>
<h2>Hello World!</h2>
<!-- set标签存值到scope中 -->
<!-- <c:set value="老梁" var="lao" scope="session"></c:set> -->
<c:set  var="lao" scope="session">老梁</c:set>
<c:out value="${lao}"></c:out>
<!-- 使用set标签给javaBean赋值 :target属性指定赋值的JavaBean对象-->
<c:set target="${user}" property="username" value="老梁1"></c:set>
<c:out value="${user.username }"></c:out>
<img alt="" src="${pic_url}timor.jpg" style="border:1px solid;border-radius: 1000px" onmousemove="hello()">
<div id="testfor">
	
</div>
	<div>
		<img id="show-picture" src="" width="150px" height="150px">
		<input id="new-picture" name="file" type="file"/>
		<button id="upload">上传图片</button>
	</div>
</body>
</html>
