<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Time</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<link rel="stylesheet" type="text/css" href="css/shop.css" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Resale Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<!-- //for-mobile-apps -->
<!--fonts-->
<link href='https://fonts.googleapis.com/css?family=Ubuntu+Condensed'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="js/myjs/shop.js"></script>
<!-- js -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script>
	function goodsList(type) {
		$
				.ajax({
					url : "http://19150t59i3.iask.in:23915/Time/goods/goodsList",
					type : "post",
					xhrFields : {
						withCredentials : true
					},
					crossDomain : true,
					dataType : "json",
					data : {
						'roleType' : "${user.rType}",
						'goodsType' : type
					},
					success : function(result) {
						// 输出到列表；
						var listdiv = document.getElementById("goodsdiv");
						var allgoods = document.getElementById("allgoods");
						var userId = "${user.uId}";
						var credit = "${user.credit}";
						var array = new Array();
						array = result;
						var list = "<ul id='goodslist' class='list'>";
						for (var i = 1; i <= array.length; i++) {
							list += "<a href='javascript:;'><li>"
									+ "<img src='"
									+array[i-1].gLogo
									+"' title='' alt='' />"
									+ "<section class='list-left'>"
									+ "<h5 class='title'>"
									+ "奖品名称："
									+ array[i - 1].gName
									+ "</h5>"
									+ "<span class='adprice'>"
									+ "所需积分:"
									+ array[i - 1].consume
									+ "</span>"
									+ "<button id='"
									+ array[i - 1].gId
									+ "' name='"
									+ array[i - 1].consume
									+ "' onclick='toConfirmChange(this.id,this.name,"
									+ userId
									+ ","
									+ credit
									+ ")'>兑换商品</button>"
									+ "</section><section class='list-right'>"
									+ "<span class='date'>"
									+ "剩余商品数量:"
									+ array[i - 1].count
									+ "</span>"
									+ "</section><div class='clearfix'></div></li></a>";

						}
						list += "</ul>"
						listdiv.innerHTML = list;
						allgoods.innerHTML = list;
					}
				});
	}
</script>
<script>
	$(document)
			.ready(
					function showAddress() {
						$
								.ajax({
									url : "http://19150t59i3.iask.in:23915/Time/user/showAddress",
									type : "post",
									xhrFields : {
										withCredentials : true
									},
									crossDomain : true,
									dataType : "json",
									data : {
										'uId' : "${user.uId}"
									},
									success : function(result) {
										// 选择输出div
										var select = document
												.getElementById("select-address");
										var array = new Array();
										array = result;
										for (var i = 0; i < array.length; i++) { // 循环添加多个option
											var varItem = new Option(
													array[i].province + " "
															+ array[i].city
															+ " "
															+ array[i].detail,
													array[i].adrId);
											select.options.add(varItem);
										}
									}
								});
					});
</script>
<script type="text/javascript" src="js/myjs/shop.js"></script>

<script>
	$(document).ready(goodsTypeList());
	$(document).ready(goodsList());
</script>

<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link href="css/jquery.uls.css" rel="stylesheet" />
<link href="css/jquery.uls.grid.css" rel="stylesheet" />
<link href="css/jquery.uls.lcd.css" rel="stylesheet" />
<!-- Source -->
<script src="js/jquery.uls.data.js"></script>
<script src="js/jquery.uls.data.utils.js"></script>
<script src="js/jquery.uls.lcd.js"></script>
<script src="js/jquery.uls.languagefilter.js"></script>
<script src="js/jquery.uls.regionfilter.js"></script>
<script src="js/jquery.uls.core.js"></script>

<script src="js/tabs.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var elem = $('#container ul');
				$('#viewcontrols a').on(
						'click',
						function(e) {
							if ($(this).hasClass('gridview')) {
								elem.fadeOut(1000, function() {
									$('#container ul').removeClass('list')
											.addClass('grid');
									$('#viewcontrols').removeClass(
											'view-controls-list').addClass(
											'view-controls-grid');
									$('#viewcontrols .gridview').addClass(
											'active');
									$('#viewcontrols .listview').removeClass(
											'active');
									elem.fadeIn(1000);
								});
							} else if ($(this).hasClass('listview')) {
								elem.fadeOut(1000, function() {
									$('#container ul').removeClass('grid')
											.addClass('list');
									$('#viewcontrols').removeClass(
											'view-controls-grid').addClass(
											'view-controls-list');
									$('#viewcontrols .gridview').removeClass(
											'active');
									$('#viewcontrols .listview').addClass(
											'active');
									elem.fadeIn(1000);
								});
							}
						});
			});
</script>


</head>
<body>
	<!--
	时间：2018-06-02
	描述：顶部标题模块
-->
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="index.jsp"><span>积分</span>商城</a>
			</div>
			<div class="header-right">
				<a class="account" href="personal.jsp">个人中心</a> <a> <span
					class="active uls-trigger"> </span></a>
				<div class="selectregion">
					<button id="konw-credits-btn" class="btn btn-primary"
						onclick="toKnowCredits()">了解积分</button>
				</div>
			</div>
		</div>
	</div>
	<!--
    	时间：2018-06-02
    	描述：了解积分弹出窗口
    -->
	<div id="know-credits-box" style="display: none;">
		<p align="center" style="font-size: 23px; color: #FF9E29">STEP1:赚取积分</p>
		<p style="margin: 0px 5px;">在Time定时消费后，根据您的开始时间和结束时间获得的时长，您能获得额度不等的Time积分。</p>
		<hr />
		<p align="center" style="font-size: 23px; color: #FF9E29">STEP2:积累积分</p>
		<p style="margin: 0px 5px;">使用Time平台进行任务规划，设置时长并完成，您将获得不同的积分</p>
		<hr />
		<p align="center" style="font-size: 23px; color: #FF9E29">STEP3:使用积分</p>
		<p style="margin: 0px 5px;">您的Time积分能退换Time积分商城的高价值礼品。</p>
	</div>


	<div class="banner text-center">
		<div class="container">
			<h1>千分之累积&nbsp;&nbsp;始于汝足下</h1>
		</div>
	</div>


	<!-- Products -->
	<div class="total-ads main-grid-border">
		<div class="container">
			<div class="all-categories" align="center">
				<h3>商品列表</h3>
			</div>
			<div class="ads-grid">
				<div class="ads-display col-md-9">
					<div class="wrapper">
						<div class="bs-example bs-example-tabs" role="tabpanel"
							data-example-id="togglable-tabs">
							<!--
                        	时间：2018-06-02
                        	描述：商品分类选项卡
                        -->
							<div id="goodsTypeDiv">
								<!-- <ul id="myTab" class="nav nav-tabs nav-tabs-responsive"
								role="tablist">
								<li role="presentation" class="active"><a href="#home"
									id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
									aria-expanded="true"> <span class="text">所有商品</span>
								</a></li>
								<li role="presentation" class="next"><a href="#profile"
									role="tab" id="profile-tab" data-toggle="tab"
									aria-controls="profile"> <span class="text">数码</span>
								</a></li>
								<li role="presentation"><a href="#samsa" role="tab"
									id="samsa-tab" data-toggle="tab" aria-controls="samsa"> <span
										class="text">家居</span>
								</a></li>
							</ul> -->
							</div>

							<div id="myTabContent" class="tab-content">
								<div role="tabpanel" class="tab-pane fade in active" id="home"
									aria-labelledby="home-tab">
									<div>
										<!--
                            	时间：2018-06-02
                            	描述：所有商品列表
                            -->
										<div id="container">
											<!-- 排列方式-->
											<div class="view-controls-list" id="viewcontrols">
												<label>view :</label> <a class="gridview"><i
													class="glyphicon glyphicon-th"></i></a> <a
													class="listview active"><i
													class="glyphicon glyphicon-th-list"></i></a>
											</div>

											<div class="clearfix"></div>
											<div id="allgoods">
												<!-- 所有商品列表 -->
											</div>


										</div>
									</div>
								</div>







								<div role="tabpanel" class="tab-pane fade" id="samsa"
									aria-labelledby="samsa-tab">
									<div>

										<div id="container">
											<!--排列方式-->
											<div class="view-controls-list" id="viewcontrols">
												<label>view :</label> <a class="gridview"><i
													class="glyphicon glyphicon-th"></i></a> <a
													class="listview active"><i
													class="glyphicon glyphicon-th-list"></i></a>
											</div>

											<div class="clearfix"></div>
											<div id="goodsdiv">
												<!-- 家具列表 -->

											</div>
										</div>
									</div>
								<!-- </div>
								<ul class="pagination pagination-sm">
									<li><a href="#">Prev</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">6</a></li>
									<li><a href="#">7</a></li>
									<li><a href="#">8</a></li>
									<li><a href="#">Next</a></li>
								</ul>
							</div> -->
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- 
		商品兑换弹出窗口确认模块（使用标签迭代，将该用户的所有收货地址存入下拉框中）
	 -->
	<div id="confirm-change-box" align="center">
		<br />
		<p>请选择收货地址：</p>
		<br />
		<p>
			<select id="select-address">
				<!-- 迭代此<option>标签，将该用户所有收货地址存入option中 -->
			</select>
		</p>
		<br />
		<p>
			<button id="confirm-change-btn" onClick="change()">确认兑换</button>
		</p>
	</div>
	<!-- // Products -->

	<!--
        	时间：2018-06-02
        	描述：底部皮皮模块
        -->
	<footer>
		<div class="footer-top">
			<div class="container">
				<div class="foo-grids">
					<div class="col-md-3 footer-grid">
						<h4 class="footer-head">Who We Are</h4>
						<p>我们是来自武汉商学院15级软工3班的小哥哥小姐姐们.</p>

					</div>
					<div class="col-md-3 footer-grid">
						<h4 class="footer-head">Help</h4>
						<ul>
							<li><a href="javascript:;">yayaya</a></li>
						</ul>
					</div>
					<div class="col-md-3 footer-grid">
						<h4 class="footer-head">Contact Us</h4>
						<ul class="location">
							<li><span class="glyphicon glyphicon-earphone"></span></li>
							<li>想打电话吗，哈哈来观4观7找我们呀</li>
							<div class="clearfix"></div>
						</ul>
						<ul class="location">
							<li><span class="glyphicon glyphicon-envelope"></span></li>
							<li><a href="mailto:info@example.com">嘻嘻都是qq邮箱</a></li>
							<div class="clearfix"></div>
						</ul>
						</address>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="footer-bottom text-center">
			<div class="container">
				<div class="footer-logo">
					<a href="index.jsp"><span>积分</span>商城</a>
				</div>
			</div>
	</footer>
	<!--footer section end-->
</body>
</html>