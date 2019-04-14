<%@page import="com.time.entity.Manager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- 管理员如果没有登录会跳转到登录页 -->
<%
	Manager manager = (Manager) session.getAttribute("manager");
	if (manager == null) {
%>
<script type="text/javascript">
	window.location.href = "login.jsp";
</script>
<%
	}
%>
<title>商品提交</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-select.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<!-- for-mobile-apps -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords"
	content="Resale Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, &#10;Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design">
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<!-- //for-mobile-apps -->
<!--fonts-->
<link href="https://fonts.googleapis.com/css?family=Ubuntu+Condensed"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic"
	rel="stylesheet" type="text/css">
<!--//fonts-->
<!-- js -->
<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/myjs/manager.js"></script>
<!-- js -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script>
	$(document).ready(function() {
		var mySelect = $('#first-disabled2');

		$('#special').on('click', function() {
			mySelect.find('option:selected').prop('disabled', true);
			mySelect.selectpicker('refresh');
		});

		$('#special2').on('click', function() {
			mySelect.find('option:disabled').prop('disabled', false);
			mySelect.selectpicker('refresh');
		});

		$('#basic2').selectpicker({
			liveSearch : true,
			maxOptions : 1
		});
	});
</script>
<script src="js/jquery.leanModal.min.js" type="text/javascript"></script>
<link href="css/jquery.uls.css" rel="stylesheet">
<link href="css/jquery.uls.grid.css" rel="stylesheet">
<link href="css/jquery.uls.lcd.css" rel="stylesheet">
<!-- Source -->
<script src="js/jquery.uls.data.js"></script>
<script src="js/jquery.uls.data.utils.js"></script>
<script src="js/jquery.uls.lcd.js"></script>
<script src="js/jquery.uls.languagefilter.js"></script>
<script src="js/jquery.uls.regionfilter.js"></script>
<script src="js/jquery.uls.core.js"></script>

<script>
<!-- 页面加载的时候获取商品种类，并添加到select标签中 -->
	$(document).ready(goodsTypeList());
</script>
<link href="css/easy-responsive-tabs.css " rel="stylesheet"
	type="text/css">
<script src="js/easyResponsiveTabs.js"></script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="main.jsp"><span>回到</span>首页</a>
			</div>
			<div class="header-right">
				<a class="account" href="login.jsp">个人中心</a> <span
					class="active uls-trigger">选择语言</span>
				<!-- Large modal -->

			</div>
		</div>
	</div>
	<div class="banner text-center">
		<div class="container">
			<h1>
				欢迎你管理员 <span class="segment-heading"> </span>
			</h1>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry</p>
			<a href="post-ad.html">Post Free Ad</a>
		</div>
	</div>
	<!-- Submit Ad -->
	<div class="submit-ad main-grid-border">
		<div class="container">
			<h2 class="head">提交文件</h2>
			<div class="post-ad-form">
				<form>
					<label>Select Category <span>*</span></label> <select id="category">

					</select>

					<div class="clearfix"></div>
					<label>Good sName<span>*</span></label> <input id="gname"
						class="phone" type="text" placeholder="">
					<div class="clearfix"></div>
					<label>Good Num<span>*</span></label> <input id="gnum"
						class="phone" type="text" placeholder="">
					<div class="clearfix"></div>
					<label>Good Count<span>*</span></label> <input id="count"
						class="phone" type="text" placeholder="">
					<div class="clearfix"></div>
					<label>Good Consume<span>*</span></label> <input id="consume"
						class="phone" type="text" placeholder="">
					<div class="clearfix"></div>
					<label>Goods Icon<span>*</span></label> <input id="gicon"
						class="phone" type="text" placeholder="">
					<div class="clearfix"></div>
					<input type="submit" value="提交" onclick="addgoods()" />
				</form>
			</div>

			<div class="post-ad-form">
				<form method="post" action="${ctx}/manager/uploadGoods"
					enctype="multipart/form-data">
					<label>Choose File:</label> <br /> <input type="file"
						name="uploadFile" /> <br /> <input type="submit" value="上传" />
				</form>
			</div>

		</div>
	</div>
	<!-- // Submit Ad -->
	<!--footer section start-->
	<footer>
		<div class="footer-bottom text-center">
			<div class="container">
				<div class="footer-logo">
					<a href="index.html"><span>Re</span>sale</a>
				</div>
				<div class="footer-social-icons">
					<ul>
						<li><a class="facebook" href="#"><span>Facebook</span></a></li>
						<li><a class="twitter" href="#"><span>Twitter</span></a></li>
						<li><a class="flickr" href="#"><span>Flickr</span></a></li>
						<li><a class="googleplus" href="#"><span>Google+</span></a></li>
						<li><a class="dribbble" href="#"><span>Dribbble</span></a></li>
					</ul>
				</div>
				<div class="copyrights">
					<p>
						Copyright © 2016.Company name All rights reserved.More Templates <a
							title="模板之家" href="http://www.cssmoban.com/" target="_blank">模板之家</a>
						- Collect from <a title="网页模板" href="http://www.cssmoban.com/"
							target="_blank">网页模板</a>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</footer>
	<!--footer section end-->

</body>
</html>