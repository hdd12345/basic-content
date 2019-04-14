<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title>Account</title>
		<!-- Custom Theme files -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<script type="application/x-javascript">
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
			}
		</script>
		<!-- //Custom Theme files -->
		<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
		<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
		<link href="css/mycss/register.css" type="text/css" rel="stylesheet"/>
		<!-- js -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
		<script src="layer/layer.js" type="text/javascript"></script>
		<script src="js/myjs/updatepassword.js" type="text/javascript"></script>
		<script src="js/md5.js" type="text/javascript"></script>
		<!-- //js -->
		<!-- cart -->
		<script src="js/simpleCart.min.js">
		</script>
		<!-- cart -->
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
							<li>
								<a href="index.jsp" class="active">首页</a>
							</li>

						</ul>
						<!--/.navbar-collapse-->
					</div>
					<!--//navbar-header-->
				</nav>

				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
		</div>
		<!--//header-->
		<!--account-->
		<div class="account">
			<div class="container">
				<div class="register">
					<form>
						<div class="register-top-grid" align="center">
							<h3>修改密码</h3>
							
							<div class="input">
								<span>旧密码<label>*</label></span>
								<input class="myinput" type="password" name="oldpassword" id="oldpassword">
							</div>
							

							<div class="input">
								<span>新密码<label>*</label></span>
								<input class="myinput" type="password" name="password" id="password">
							</div>
							<div class="input">
								<span>确认密码<label>*</label></span>
								<input class="myinput" type="password" name="confirmPassword" id="confirmPassword">
							</div>
							
							
							
							</div>

						</div>
					</form>
					<div class="clearfix"> </div>
					<div class="register-but">
						<div align="center">
							<input id="updatepassword" type="button" value="提交">
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--//account-->
		
		<!-- 激活账号模块 -->
		<div id="active-box" align="center" style="display: none">
		<p align="center">注册成功！请前往邮箱查看激活码！</p>
		<input type="text" id="activeCode"><br>
		<button id="active" >激活账号</button>
		</div>
		
		<!--footer-->
		<!--
        	作者：offline
        	时间：2018-09-17
        	描述：底部打酱油模块
        -->
		<div class="footer">
			<div class="container">
				<div class="footer-grids">
					<div class="col-md-2 footer-grid">
						<h4>公司</h4>
						<ul>
							<li>
								<a href="products.jsp">制品</a>
							</li>
							<li>
								<a href="#">在这里工作</a>
							</li>
							<li>
								<a href="#">团队</a>
							</li>
							<li>
								<a href="#">精彩</a>
							</li>
							<li>
								<a href="#">经销商定位器</a>
							</li>
						</ul>
					</div>
					<div class="col-md-2 footer-grid">
						<h4>服务</h4>
						<ul>
							<li>
								<a href="#">支持</a>
							</li>
							<li>
								<a href="#">常问问题</a>
							</li>
							<li>
								<a href="#">保证</a>
							</li>
							<li>
								<a href="contact.jsp">连续我们</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3 footer-grid">
						<h4>订单与退货</h4>
						<ul>
							<li>
								<a href="#">订单状态</a>
							</li>
							<li>
								<a href="#">送货政策</a>
							</li>
							<li>
								<a href="#">退货政策</a>
							</li>
							<li>
								<a href="#"></a>
							</li>数字礼品卡
						</ul>
					</div>
					<div class="col-md-2 footer-grid">
						<h4>法律</h4>
						<ul>
							<li>
								<a href="#">隐私</a>
							</li>
							<li>
								<a href="#">条款和条件</a>
							</li>
							<li>
								<a href="#">社会责任感</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3 footer-grid icons">
						<h4>联系我们</h4>
						<ul>
							<li>
								<a href="#"><img src="images/i1.png" alt="" />在Facebook上关注我们</a>
							</li>
							<li>
								<a href="#"><img src="images/i2.png" alt="" />在推特上关注我们</a>
							</li>
							<li>
								<a href="#"><img src="images/i3.png" alt="" />在Google-Plus上关注我们</a>
							</li>
							<li>
								<a href="#"><img src="images/i4.png" alt="" />在Pinterest上关注我们</a>
							</li>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		</div>
		<!--footer-->
		<div class="footer-bottom">
			<div class="container">
				<p>Copyright &copy; 2015.Company name All rights reserved.More Templates
					<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from
					<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</p>
			</div>
		</div>
		<input type="hidden" id="currentPwd" value="${user.password}">
	</body>

</html>