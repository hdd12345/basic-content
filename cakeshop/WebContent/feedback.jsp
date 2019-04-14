<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户反馈</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
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
						<li><a href="index.jsp" class="active">主页</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">生日<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-4">
								<div class="row">
									<div class="col-sm-3">
										<h4>亲友</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">朋友</a></li>
											<li><a class="list" href="products.jsp">爱人</a></li>
											<li><a class="list" href="products.jsp">姐妹</a></li>
											<li><a class="list" href="products.jsp">兄弟</a></li>
											<li><a class="list" href="products.jsp">孩子</a></li>
											<li><a class="list" href="products.jsp">父母</a></li>
										</ul>
									</div>																		
									<div class="col-sm-3">
										<h4>口味</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">巧克力</a></li>
											<li><a class="list" href="products.jsp">水果</a></li>
											<li><a class="list" href="products.jsp">奶油</a></li>
											<li><a class="list" href="products.jsp">糖果</a></li>
											<li><a class="list" href="products.jsp">抹茶</a></li>
											<li><a class="list" href="products.jsp">无鸡蛋</a></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<h4>主题</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">心形</a></li>
											<li><a class="list" href="products.jsp">卡通蛋糕</a></li>
											<li><a class="list" href="products.jsp">2-3层蛋糕</a></li>
											<li><a class="list" href="products.jsp">正方形</a></li>
											<li><a class="list" href="products.jsp">圆形</a></li>
											<li><a class="list" href="products.jsp">照片蛋糕</a></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<h4>重量</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">1 kG</a></li>
											<li><a class="list" href="products.jsp">1.5 kG</a></li>
											<li><a class="list" href="products.jsp">2 kG</a></li>
											<li><a class="list" href="products.jsp">3 kG</a></li>
											<li><a class="list" href="products.jsp">4 kG</a></li>
											<li><a class="list" href="products.jsp">大</a></li>
										</ul>
									</div>
								</div>
							</ul>
						</li>
					   <li class="dropdown grid">
							<a href="#" class="dropdown-toggle list1" data-toggle="dropdown">婚礼<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-4">
								<div class="row">
									<div class="col-sm-3">
										<h4>亲友</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">朋友</a></li>
											<li><a class="list" href="products.jsp">爱人</a></li>
											<li><a class="list" href="products.jsp">姐妹</a></li>
											<li><a class="list" href="products.jsp">兄弟</a></li>
											<li><a class="list" href="products.jsp">孩子</a></li>
											<li><a class="list" href="products.jsp">父母</a></li>
										</ul>
									</div>																		
									<div class="col-sm-3">
										<h4>口味</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">巧克力</a></li>
											<li><a class="list" href="products.jsp">水果</a></li>
											<li><a class="list" href="products.jsp">奶油</a></li>
											<li><a class="list" href="products.jsp">糖果</a></li>
											<li><a class="list" href="products.jsp">抹茶</a></li>
											<li><a class="list" href="products.jsp">无鸡蛋</a></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<h4>主题</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">心形</a></li>
											<li><a class="list" href="products.jsp">卡通蛋糕</a></li>
											<li><a class="list" href="products.jsp">2-3层蛋糕</a></li>
											<li><a class="list" href="products.jsp">正方形</a></li>
											<li><a class="list" href="products.jsp">圆形</a></li>
											<li><a class="list" href="products.jsp">照片蛋糕</a></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<h4>重量</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">1 kG</a></li>
											<li><a class="list" href="products.jsp">1.5 kG</a></li>
											<li><a class="list" href="products.jsp">2 kG</a></li>
											<li><a class="list" href="products.jsp">3 kG</a></li>
											<li><a class="list" href="products.jsp">4 kG</a></li>
											<li><a class="list" href="products.jsp">大</a></li>
										</ul>
									</div>
								</div>
							</ul>
						</li>				
						<li class="dropdown grid">
							<a href="#" class="dropdown-toggle list1" data-toggle="dropdown">特价 <b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-4">
								<div class="row">
									<div class="col-sm-3">
										<h4>亲友</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">朋友</a></li>
											<li><a class="list" href="products.jsp">爱人</a></li>
											<li><a class="list" href="products.jsp">姐妹</a></li>
											<li><a class="list" href="products.jsp">兄弟</a></li>
											<li><a class="list" href="products.jsp">孩子</a></li>
											<li><a class="list" href="products.jsp">父母</a></li>
										</ul>
									</div>																		
									<div class="col-sm-3">
										<h4>口味</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">巧克力</a></li>
											<li><a class="list" href="products.jsp">水果</a></li>
											<li><a class="list" href="products.jsp">奶油</a></li>
											<li><a class="list" href="products.jsp">糖果</a></li>
											<li><a class="list" href="products.jsp">抹茶</a></li>
											<li><a class="list" href="products.jsp">无鸡蛋</a></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<h4>主题</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">心形</a></li>
											<li><a class="list" href="products.jsp">卡通蛋糕</a></li>
											<li><a class="list" href="products.jsp">2-3层蛋糕</a></li>
											<li><a class="list" href="products.jsp">正方形</a></li>
											<li><a class="list" href="products.jsp">圆形</a></li>
											<li><a class="list" href="products.jsp">照片蛋糕</a></li>
										</ul>
									</div>
									<div class="col-sm-3">
										<h4>重量</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">1 kG</a></li>
											<li><a class="list" href="products.jsp">1.5 kG</a></li>
											<li><a class="list" href="products.jsp">2 kG</a></li>
											<li><a class="list" href="products.jsp">3 kG</a></li>
											<li><a class="list" href="products.jsp">4 kG</a></li>
											<li><a class="list" href="products.jsp">大</a></li>
										</ul>
									</div>
								</div>
							</ul>
						</li>
						<li class="dropdown grid">
							<a href="#" class="dropdown-toggle list1" data-toggle="dropdown">商店<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-3">
								<div class="row">
									<div class="col-sm-4">
										<h4>亲友</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">朋友</a></li>
											<li><a class="list" href="products.jsp">爱人</a></li>
											<li><a class="list" href="products.jsp">姐妹</a></li>
											<li><a class="list" href="products.jsp">兄弟</a></li>
											<li><a class="list" href="products.jsp">孩子</a></li>
											<li><a class="list" href="products.jsp">父母</a></li>
										</ul>
									</div>																		
									<div class="col-sm-4">
										<h4>口味</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">巧克力</a></li>
											<li><a class="list" href="products.jsp">水果</a></li>
											<li><a class="list" href="products.jsp">奶油</a></li>
											<li><a class="list" href="products.jsp">糖果</a></li>
											<li><a class="list" href="products.jsp">抹茶</a></li>
											<li><a class="list" href="products.jsp">无鸡蛋</a></li>
										</ul>
									</div>								
									<div class="col-sm-4">
										<h4>特价</h4>
										<ul class="multi-column-dropdown">
											<li><a class="list" href="products.jsp">冰淇淋蛋糕</a></li>
											<li><a class="list" href="products.jsp">瑞士卷</a></li>
											<li><a class="list" href="products.jsp">Ruske kape</a></li>
											<li><a class="list" href="products.jsp">纸杯蛋糕</a></li>
											<li><a class="list" href="products.jsp">松饼</a></li>
											<li><a class="list" href="products.jsp">Merveilleux</a></li>										
										</ul>
									</div>
								</div>
							</ul>
						</li>								
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
								Search
							</button>
						</form>
					</div>	
				</div>
				<div class="header-right login">
					<a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
					<div id="loginBox">                
						<form id="loginForm">
							<fieldset id="body">
								<fieldset>
									<label for="email">邮箱地址</label>
									<input type="text" name="email" id="email">
								</fieldset>
								<fieldset>
									<label for="password">密码</label>
									<input type="password" name="password" id="password">
								</fieldset>
								<input type="submit" id="login" value="登录">
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>记住密码</i></label>
							</fieldset>
							<p>新用户 <a class="sign" href="account.jsp">注册</a> <span><a href="#">忘记密码</a></span></p>
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
	<!--contact-->
	<div class="contact">
		<div class="container">
			<h2>联系我们</h2>
			<div class="map">	
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d205251.8961757029!2d-82.55659211602483!3d36.50439253757311!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x885a856b70074b97%3A0x6f9cc0d30bcc841f!2sKingsport%2C+TN%2C+USA!5e0!3m2!1sen!2sin!4v1433743549812"></iframe>
			</div>
			<div class="contact-infom">
				<h4>杂项信息 :</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sheets containing Lorem Ipsum passages, 
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.It was popularised in the 1960s with the release of Letraset
					and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</div>
			<div class="address">
				<div class="col-md-4 address-grids">
					<h4>地址 :</h4>
					<ul>
						<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<p>	Eiusmod Tempor inc<br>
							St Dolore Place,<br>
							Kingsport 56777
						</p>
					</ul>
				</div>
				<div class="col-md-4 address-grids">
					<h4>联系方式 :</h4>
					<p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+2 800 544 6035</p>
					<p><span class="glyphicon glyphicon-print" aria-hidden="true"></span>+2 100 889 9466</p>
				</div>
				<div class="col-md-4 address-grids">
					<h4>邮箱 :</h4>
					<p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><a href="mailto:example@mail.com">mail@example.com</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>		
			<div class="contact-form">
				<h4>联系方式</h4>
				<form>
					<input type="text" value="名字" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
					<input type="text" value="邮箱" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="text" value="电话" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Telephone';}" required="">
					<textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
					<button class="btn1">提交</button>
				</form>
			</div>	
		</div>
	</div>
	<!--//contact-->
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
						<li><a href="#">经销商定位器</a></li>
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
						<li><a href="#">送货说明</a></li>
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
						<li><a href="#"><img src="images/i1.png" alt=""/>facebook</a></li>
						<li><a href="#"><img src="images/i2.png" alt=""/>Twitter</a></li>
						<li><a href="#"><img src="images/i3.png" alt=""/>Google-plus</a></li>
						<li><a href="#"><img src="images/i4.png" alt=""/>Pinterest</a></li>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
		</div>
	</div>
</body>
</html>