<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>购物车</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/mycss/cart.css" type="text/css" rel="stylesheet">
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="layer/layer.js" type="text/javascript"></script>
<script src="js/myjs/login.js" type="text/javascript"></script>
<script src="js/myjs/cart.js" type="text/javascript"></script>
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
<%		if(session.getAttribute("user")==null){
			response.sendRedirect("index.jsp");
		}%>
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
				<!--navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="index.jsp" class="active">首页</a></li>
						
					  
						
									
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
				
				
				<div class="header-right login" id="login-box">
					<a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
					<div id="loginBox">                
						<form id="loginForm">
							<fieldset id="body">
								<fieldset>
									<label for="email">用户名</label>
									<input type="text" name="username" id="username">
								</fieldset>
								<fieldset>
									<label for="password">密码</label>
									<input type="password" name="password" id="password">
								</fieldset>
								<input type="button" id="login" value="登录">
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
							</fieldset>
							<p>新用户 <a class="sign" href="register.jsp">注册</a> <span><a href="#">忘记密码</a></span></p>
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
						<h4><a href="checkout.jsp">
							<span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>) 
						</a></h4>
						<p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//header-->
	<!--cart-items-->
	<div style="float:right;">
	<button id="delete">删除</button>
	</div>
	<div style="float:right;">
	<button id="tobuy" onclick="tobuy()">结算</button>
	</div>
	<div class="cart-items" id="cartitem-box">
		<div class="container">
			<h2>My Shopping Cart(3)</h2>
			<!--
            	作者：offline
            	时间：2018-09-17
            	描述：
            <script>$(document).ready(function(c) {
				$('.close1').on('click', function(c){
					$('.cart-header').fadeOut('slow', function(c){
						$('.cart-header').remove();
					});
					});	  
				});
			</script>-->
			<div class="cart-header">
				<div class="close1"> <input type="checkbox" name="check"></div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/m1.png" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
						<ul class="qty">
							<li><p>Min. order value:</p></li>
							<li><p>FREE delivery</p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : $10.00</p>
							<span>Delivered in 1-1:30 hours</span>
							<div class="clearfix"></div>
						</div>	
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			 <!--<script>$(document).ready(function(c) {
					$('.close2').on('click', function(c){
							$('.cart-header2').fadeOut('slow', function(c){
						$('.cart-header2').remove();
					});
					});	  
					});
			</script>-->
			<!-- <div class="cart-header2">
				<div class="close2"> <input type="checkbox" name="check"></div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/m2.png" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
						<ul class="qty">
							<li><p>Min. order value:</p></li>
							<li><p>FREE delivery</p></li>
						</ul>
						<div class="delivery">
						<p>Service Charges : $10.00</p>
						<span>Delivered in 1-1:30 hours</span>
						<div class="clearfix"></div>
					</div>	
				   </div>
				   <div class="clearfix"></div>
				</div>
			</div>
				<script>$(document).ready(function(c) {
					$('.close3').on('click', function(c){
							$('.cart-header3').fadeOut('slow', function(c){
						$('.cart-header3').remove();
					});
					});	  
					});
			</script>
			<div class="cart-header3">
				<div class="close3"> <input type="checkbox" name="check"></div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/m3.png" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
						<ul class="qty">
							<li><p>Min. order value:</p></li>
							<li><p>FREE delivery</p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : $10.00</p>
							<span>Delivered in 1-1:30 hours</span>
							<div class="clearfix"></div>
						</div>	
					</div>
					<div class="clearfix"></div>
				</div>
			</div>	 -->	
		</div>
	</div>
	<!--//checkout-->	
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved</p>
		</div>
	</div>
	
	<div id="select-address-box" align="center" style="display: none">
		<p>
			<select id="my-address">
				<option selected value="address_id">1111</option>
			</select>
		</p>
		<p><button id="buy" onclick="buy()">确认</button></p>
	</div>
	<input id="user_id" type="hidden" value="${user.user_id}">
</body>
</html>