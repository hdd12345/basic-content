<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Provaypro 管理系统</title>
</head>
<link href="css/base/jquery-ui-1.10.4.custom.css" rel="stylesheet">
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<style>
	body{ margin: 0;padding: 0;font-family: "微软雅黑";overflow: hidden;}
body,html{-webkit-text-size-adjust: none;width: 100%;height: 100%;}
*{text-decoration: none;list-style: none;}
img{border: 0px;}
ul,li,dl,dd,dt,p,ol,h1,h2,h3,h4,h5{font-size: 12px;font-weight: 100;padding: 0;margin: 0;}
.wrap{margin: 0 auto;}
.fl{float: left;}
.fr{float: right;}
.index{overflow: hidden;}
.clr{clear:both; height:0px; width:100%; font-size:1px; line-height:0px; visibility:hidden; overflow:hidden;}
.pointer{cursor:pointer;}
a,input,button{ outline:none; }
::-moz-focus-inner{border:0px;}

a{color: #000;}
.wrapper{clear: both;width: 100%;}
table { border-collapse:collapse; }

	
	
	#header{
		background-color: #107BA6;
		width: auto;
		height: 50px;
		
	}	
	.table{
		position: absolute;left:55%;top:20%;
		margin: 0 auto;
		width: 30%;
		height: 40%;
		border:2px solid #757575;
		text-align: center;
		background-color: #f9f9f9;
	}
	.table-span {
            text-align: right;
            width: 100px;
            display: inline-block;
			font-size: 16px;
			margin-right: 4%;
        }
	 form div{
		margin: 5%;
	}
	.tet{
		width: 40%;
		height: 40px;
		border: 1px solid #FFFFFF;
		border-radius: 6px;
	}
	.anniu{
		width: 140px;
		height: 40px;
		text-align: center;
		border-radius: 4px;
		border: 1px solid #606060;
		background-color: #107BA6;
		color: #ffffff;
	}
	
</style>
 

<script type="text/javascript">

	//服务器校验
	function severCheck(){
		if(check()){
			
			var username = $("#username").val();
			var password = $("#password").val();
			var code =  username+",fh,"+password +",fh," ;
			$.ajax({
				type: "POST",
				url: '${pageContext.request.contextPath }/loginregister/login',
		    	data: {KEYDATA:code},
				dataType:'json',
				cache: false,
				success: function(data){
					if("success" == data.result){
						saveCookie();
						window.location.href="main/index";
					}else if("usererror" == data.result){
						$("#username").tips({
							side : 1,
							msg : "用户名或密码有误",
							bg : '#FF5080',
							time : 15
						});
						$("#username").focus();
					} else{
						$("#username").tips({
							side : 1,
							msg : "缺少参数",
							bg : '#FF5080',
							time : 15
						});
						$("#username").focus();
					}
				}
			});
		}
	}

	 

	 
 
	//客户端校验
	function check() {

		if ($("#username").val() == "") {

			$("#username").tips({
				side : 2,
				msg : '用户名不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#username").focus();
			return false;
		} else {
			$("#username").val(jQuery.trim($('#username').val()));
		}

		if ($("#password").val() == "") {

			$("#password").tips({
				side : 2,
				msg : '密码不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#password").focus();
			return false;
		}
		 
		$("#main").tips({
			side : 1,
			msg : '正在登录 , 请稍后 ...',
			bg : '#68B500',
			time : 10
		});

		return true;
	}
  
	function quxiao() {
		$("#username").val('');
		$("#password").val('');
	}
	
	 
</script>
	 
</head>

<body style="background-image:url(12345.gif)">
<div id="header">
	<div style="float: left;margin-top: 15px;margin-left: 10px;">
		<font color="#fff">Provaypro 管理系统</font>
	</div>
	<div style="text-align: center;float: left;margin-left:36%;margin-top: 15px;">
		<font color="#fff" >登录</font>
	</div>
</div>
<div id="main">
	<div class="table">
	<form id="form1" action="" method="post">
		<div><span class="table-span">用户名：</span><input type="text" value="" name="username" tabindex="1" placeholder="请输入用户名" class="tet"></div>
		<div><span class="table-span">密    码：</span><input type="password" value="" name="password" tabindex="2" placeholder="请输入密码" class="tet"></div>
		<div>
		<span style="margin-left: 20%;">用户类型：</span>
				<input type="radio" value="user" name="role" tabindex="3"><span style="margin-left: 1%;font-size: 12px;">个人用户</span>
				<input type="radio" value="company" name="role" tabindex="4"><span style="margin-left: 1%;font-size: 12px;">企业用户</span>
				<input type="radio" value="stuff" name="role" tabindex="5"><span style="margin-left: 1%;font-size: 12px;">员工用户</span>
		</div>
		<div style="margin-top: 50px;">
			  <a onclick="severCheck();"class="anniu"   >登录</a> 
			<input type="buttom" value="注册" name="" tabindex="7" onClick="" class="anniu">
		</div>
	</form>
	</div>
</div>
<div id="footer">
	
</div>
</body>
</html>