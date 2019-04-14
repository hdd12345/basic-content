<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>主页</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="layer/layer.js" type="text/javascript"></script>
<script src="js/myjs/login.js" type="text/javascript"></script>
<script src="js/myjs/index.js" type="text/javascript"></script>
<!-- //js -->	
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<% if(session.getAttribute("user")!=null){%>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#login-box").hide();
			$("#user-box").show();
		});
	</script>
<%}%>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<h1 class="navbar-brand"><a  href="index.jsp">Yummy</a></h1>
				</div>
				
				<!-- 二级分类模块 -->
				<!--navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" id="category">
						<!-- <li><a href="index.jsp" class="active">首页</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">生日蛋糕<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-4">
								<div class="row">		
									<div class="col-sm-3">			
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">亲友</a></li>
											<li><a class="list" href="products.jsp">口味</a></li>
											<li><a class="list" href="products.jsp">主题</a></li>
											<li><a class="list" href="products.jsp">重量</a></li>	
										</ul>
									</div>
								</div>
							</ul>
						</li> -->								
					</ul> 
					<!--/.navbar-collapse-->
				</div>
				<!--//navbar-header-->
				
				
			</nav>
			<div class="header-info">
				<div class="header-right search-box">
					<a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>				
					<div class="search">
						<form class="navbar-form">
							<input type="text" class="form-control">
							<button type="submit" class="btn btn-default" aria-label="Left Align">
								搜索
							</button>
						</form>
					</div>	
				</div>
				
				<!-- 登录模块 -->
				<div class="header-right login" id="login-box">
					<a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
					<div id="loginBox">                
						<form id="loginForm">
							<fieldset id="body">
								<fieldset>
									<label for="username">用户名</label>
									<input type="text" name="username" id="username">
								</fieldset>
								<fieldset>
									<label for="password">密码</label>
									<input type="password" name="password" id="password">
								</fieldset>
								<input type="button" id="login" value="登录" >
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>记住密码</i></label>
							</fieldset>
							<p><a class="sign" href="register.jsp">注册</a> <span><a  href="javascript:forget();">忘记密码</a> </span></p>
						</form>
					</div>
				</div>
				
				<!-- 用户信息模块：登录后才显示 -->
				<div class="header-right login" id="user-box" style="display: none">
					<a href="#">
						<img src="images/timor.jpg" style="width: 65px;height: 65px;border-radius:100px;"/>
					</a>
					<div id="loginBox">                
						<form id="loginForm">
							<fieldset id="body">
								<fieldset>
									<label for="email">
										您好！<span style="color:#F07818;">${user.name}</span>
									</label>
								</fieldset>
								<fieldset>
									<label for="password" style="color:	#800000;">美好的一天从美味的蛋糕开始！</label>
								</fieldset>
							</fieldset>
							<p><span>
							<a href="http://localhost:8080/cakeshop/user/logout">退出登录</a>|
							<a href="http://localhost:8080/cakeshop/address.jsp">管理地址</a>|
							<a href="http://localhost:8080/cakeshop/updatePassword.jsp">修改密码</a>|
							<a href="http://localhost:8080/cakeshop/orders.jsp">订单</a>
							</span></p>
						</form>
					</div>
				</div>
				
				<div class="header-right cart">
					<a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
					<div class="cart-box">
						<h4><a href="cart.jsp">
							<span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>) 
						</a></h4>
						<p><a href="cart.jsp" class="simpleCart_empty">Go To Cart</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//header-->
	<!--banner-->
	<div class="banner">
		<div class="container">
			<h2 class="hdng">Yummy <span>Cake</span></h2>
			<p>唇齿留香,妙不可言</p>
			<div class="banner-text">			
				<img src="images/2.png" alt=""/>	
			</div>
		</div>
	</div>			
	<!--//banner-->
	<!--gallery-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-grids">
				<div class="col-md-8 gallery-grid glry-one">
					<a href="products.jsp"><img src="images/g1.jpg" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>查看</p>
							<a class="shop" href="#">购买</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>丝滑巧克力松子蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4 gallery-grid glry-two">
					<a href="products.jsp"><img src="images/g2.jpg" class="img-responsive" alt=""/>
						<div class="gallery-info galrr-info-two">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
							<a class="shop" href="#">SHOP NOW</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>婚礼三层白色经典</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div id="div"></div>
				
			
			
				
			
			</div>	
		</div>
	</div>
	<!--//gallery-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved</p>
		</div>
	</div>
</body>
<script>
function forget(){
	var flag = true;
	
		$.ajax({
			url:"http://localhost:8080/cakeshop/user/checkUsername",
			type:"post",
			async:false,
			data:"username="+$("#username").val(),
			success:function(data){
				if(data==0){
					alert("该用户不存在");
					flag=false;
					
				}else{
					
					flag=true;
				}
			},
			error:function(data){
				alert("请求失败！");
			}
		});

	
	if( flag){
		$.ajax({
			url:"http://localhost:8080/cakeshop/user/forgetPassword",
			type:"get",
			data:"username="+$("#username").val(),
			
			
			success:function(data){
				if(data>0){
					alert("发送成功");
				}else{
					alert("发送失败");
				}
			},
			error:function(data){
				alert("请求失败！");
			}
		});
	
	}
	if(flag){
	var str = prompt("请输入验证码","");
	
	 $.ajax({
			url:"http://localhost:8080/cakeshop/user/resetPassword",
			type:"post",
			data:"code="+str,
			success:function(data){
				if(data>0){
					alert("密码重置成功")
				     
				}else{
					alert("验证码不正确！");
				}
			},
			error:function(data){
				alert("重置失败！");
			}
		});
	}

	
}
</script>
</html>