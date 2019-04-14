<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>商品列表</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="layer/layer.js" type="text/javascript"></script>
<script src="js/myjs/login.js" type="text/javascript"></script>
<script src="js/myjs/product.js" type="text/javascript"></script>
<!-- //js -->	
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- the jScrollPane script -->
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- //the jScrollPane script -->
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
<!-- the mousewheel plugin -->	
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
					<h1 class="navbar-brand"><a  href="index.jsp">CAKE</a></h1>
				</div>
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
									<label for="email">邮箱地址</label>
									<input type="text" name="username" id="username">
								</fieldset>
								<fieldset>
									<label for="password">密码</label>
									<input type="password" name="password" id="password">
								</fieldset>
								<input type="button" id="login" value="登录">
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>记住密码</i></label>
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
					<a href="http://localhost:8080/cakeshop/cart.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
					<div class="cart-box">
						<h4><a href="cart.jsp">
							<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>) 
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
	<!--products-->
	<!--
    	作者：offline
    	时间：2018-09-17
    	描述：商品列表
    -->
	<div class="products">	 
		<div class="container" style="padding-top: 30px;">
			<!--<h2>我们的产品</h2>	-->	
			<div align="center"><img src="images/cake.jpg" /></div>
			<div class="product-model-sec" id="product-box">
			
				<!-- <div class="product-grid">
					<a href="single.jsp">				
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/${goods.gimage }" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">							
									<button>View</button>
								</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${goods.gname }</h4>								
							<span class="item_price">${goods.gprice }</span>
							<div class="ofr">
								<p class="pric1"><del></del></p>
								<p class="disc"></p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="添加">
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div> -->	
			   
				
			</div>	
			
			
			<!--分页 -->
	<div  style="width: 380px; margin: 0 auto; margin-top: 50px;" align="center">
		<ul id="myli" class="pagination" style="text-align: center; margin-top: 10px;">
			<!-- <li class="disabled"><a href="#" aria-label="Previous"><span
					aria-hidden="true">&laquo;</span></a></li> -->
			<!-- <li class="active"><a href="#">1</a></li>			
			<li><a href="http://localhost:8080/shop/productCategory">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li> -->
			<!-- <li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li> -->
		</ul>
	</div>
	<!-- 分页结束 -->
			
	<div>浏览记录********************************</div>
	
	<div class="product-model-sec" id="history-box">
	<c:forEach items="${goodsList}" var="goods">
		<div class="product-grid">
			<a href="productInfo.jsp?goods_id=${goods.goods_id }">				
				<div class="more-product"><span> </span></div>						
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/${goods.gimage }" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">							
									<button>View</button>
								</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${goods.gname }</h4>								
							<span class="item_price">${goods.gprice }</span>
							<div class="ofr">
								<p class="pric1"><del></del></p>
								<p class="disc"></p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="添加">
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
		</c:forEach>
	</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//products-->
	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-2 footer-grid">
					<h4>公司</h4>
					<ul>
						<li><a href="products.jsp">产品</a></li>
						<li><a href="#">在这里工作</a></li>
						<li><a href="#">团队</a></li>
						<li><a href="#">精彩</a></li>
						<li><a href="#">Dealer Locator</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>服务</h4>
					<ul>
						<li><a href="#">支持</a></li>
						<li><a href="#">常见问题</a></li>
						<li><a href="#">保证</a></li>
						<li><a href="contact.jsp">联系我们</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h4>订单和退货</h4>
					<ul>
						<li><a href="#">订单状态</a></li>
						<li><a href="#">订单说明</a></li>
						<li><a href="#">退货说明</a></li>
						<li><a href="#">数字礼品卡</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>法律</h4>
					<ul>
						<li><a href="#">隐私</a></li>
						<li><a href="#">条款和条件</a></li>
						<li><a href="#">社会责任感</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid icons">
					<h4>联系我们</h4>
					<ul>
						<li><a href="#"><img src="images/i1.png" alt=""/>Facebook</a></li>
						<li><a href="#"><img src="images/i2.png" alt=""/>Twitter</a></li>
						<li><a href="#"><img src="images/i3.png" alt=""/>Google-plus</a></li>
						<li><a href="#"><img src="images/i4.png" alt=""/>Pinterest</a></li>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
		</div>
	</div>
</body>
</html>