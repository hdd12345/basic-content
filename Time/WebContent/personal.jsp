<%@page import="com.time.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- 用户如果没有登录会跳转到登录页 -->
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
%>
<script type="text/javascript">
	window.location.href = "login.jsp";
</script>
<%
	}
%>
<title>Time</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<link rel="stylesheet" type="text/css" href="css/personal.css" />
<!-- js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="js/myjs/personal.js"></script>
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
	$(document).ready(function() {
		/**
		 * 选项卡切换
		 */
		$("#left-use").click(function() {
			$(".right-content").each(function() {
				$(this).hide();
			});
			$("#time-log-content").show();
		});
		$("#left-change").click(function() {
			$(".right-content").each(function() {
				$(this).hide();
			});
			$("#change-log-content").show();
		});
		$("#left-pwd").click(function() {
			$(".right-content").each(function() {
				$(this).hide();
			});
			$("#update-pwd-content").show();
		});
		$("#left-address").click(function() {
			$(".right-content").each(function() {
				$(this).hide();
			});
			$("#update-address-content").show();
		});
	});
	//显示添加地址弹出窗口
	function toAddAddress(){
		layer.open({
			type : 1,
			title : "添加地址",
			skin : 'layui-layer-molv',
			area : [ "300px", "300px" ],
			content : $("#add-address-box")
		});
	}
	function toUpdateAddress(){
		layer.open({
			type : 1,
			title : "修改地址",
			skin : 'layui-layer-molv',
			area : [ "300px", "300px" ],
			content : $("#update-address-box")
		});
	}
	
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
<script>
	$(document).ready(function() {
		$('.uls-trigger').uls({
			onSelect : function(language) {
				var languageName = $.uls.data.getAutonym(language);
				$('.uls-trigger').text(languageName);
			},
			quickList : [ 'en', 'hi', 'he', 'ml', 'ta', 'fr' ]
		//FIXME
		});
	});
</script>
<script src="js/tabs.js"></script>


<script type="text/javascript">
	function showTimeLog() {
		$
				.ajax({
					url : "http://localhost:8080/Time/timeLog/showTimeLog",
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
						var div = document.getElementById("useLog");
						var array = new Array();
						array = result;
						var list = "";
						for (var i = 1; i <= array.length; i++) {
							var temp = array[i - 1].achieve;
							var flag = "";
							if (temp == 1) {
								flag = "<button id='delete-btn'>达到目标</button>";
							} else {
								flag = "<span>中断时间：</span><span id='stop-time'>"
										+ datetimeFormat_1(array[i - 1].failtime)
										+ "</span>";
							}
							list += "<div style='width:90%;height:70px;background-color:#f9f9f9;border:2px solid #01A185;border-radius:10px;'>"
									+ "<p style='float:left;width:10%;height:100%;border-right:1px solid grey;padding-top:10px;'>"
									+ "<span id='use-number' style='font-size:30px;'>"
									+ i
									+ "</span></p>"
									+ "<p style='float:left;width:30%;height:100%;border-right:1px solid grey;'>"
									+ "<span id='start-time'>"
									+ "</span><br/><span>开始时间：</span>"
									+ datetimeFormat_1(array[i - 1].start)
									+ "</span><br/></p>"
									+ "<p style='float:left;width:30%;height:100%;border-right:1px solid grey;'>"
									+ "<span id='stop-time'>"
									+ "</span><br/><span>结束时间：</span>"
									+ datetimeFormat_1(array[i - 1].expire)
									+ "</span><br/></p>"
									+ "<p style='float:left;width:30%;padding-top:20px;height:100%'>"
									+ flag + "</p></div>"

						}
						div.innerHTML = list;
					}
				});
	}
</script>
<script>
	function showChangeLog() {
		$
				.ajax({
					url : "http://localhost:8080/Time/user/showChangeLog",
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
						var div = document.getElementById("changeLog");
						var array = new Array();
						array = result;
						var list = "";
						for (var i = 1; i <= array.length; i++) {
							list += "<div style='width: 80%; height: 70px; background-color: #f9f9f9; "
									+ "border: 2px solid #01A185; border-radius: 10px;'>"
									+ "<p style='float: left; width: 20%; height: 100%; "
									+ "border-right: 1px solid grey; padding-top: 10px;'>"
									+ "<span id='use-number' style='font-size: 30px;'>"
									+ i
									+ "</span></p>"
									+ "<p style='float: left; width: 25%; height: 100%; "
									+ "border-right: 1px solid grey; padding-top: 20px;'>"
									+ "<span id='goods-name'>"
									+ array[i - 1].gId
									+ "</span></p>"
									+ "<p style='float: left; width: 35%; height: 100%; "
									+ "border-right: 1px solid grey; padding-top: 20px;'>"
									+ "<span>兑换时间："
									+ datetimeFormat_1(array[i - 1].clTime)
									+ "</span><span id='change-time'></span></p>"
									+ "<p style='float: left; width: 20%; padding-top: 20px; height: 100%'>"
									+ "<span id=''>花费"
									+ array[i - 1].consume
									+ "积分</span></p></div>";

						}
						div.innerHTML = list;
					}
				});
	}
</script>

<script>
<!-- 每次都应该清空标签和输入框的内容 -->
function changePwd() {
	var newPwd = $('#newPwd').val();
	if('${user.uPwd}' != $('#oldPwd').val()){
		$("#oldPwdMsg").html('')
		$("#oldPwdMsg").append("密码不正确");
	}else{
		$("#oldPwdMsg").html('')
		if(newPwd != "" && newPwd == $('#rePwd').val()){
			$.ajax({
				url : "http://localhost:8080/Time/user/modifyPwd",
				type : "post",
				xhrFields : {
					withCredentials : true
				},
				crossDomain : true,
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify({
					'uId' : "${user.uId}",
					'uPwd' : newPwd
				}),
				success : function(result) {
					if(result == 1){
						$("#changeMsg").html('')
						$("#rePwdMsg").html('')
					<!-- location.reload(true);-->
					
						$("#changeMsg").append("密码修改成功");
					}else{
						$("#changeMsg").html('')
						$("#changeMsg").append("密码修改失败");
					}
				}
			});
		}else{
			$("#changeMsg").html('')
			$("#rePwdMsg").append("两次输入密码不能为空或不一致");
		}
	}
}
</script>

<script>
function showAddress() {
		$.ajax({
				url : "http://localhost:8080/Time/user/showAddress",
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
					var div = document.getElementById("addressDiv");
					var array = new Array();
					array = result;
					var list = "";
					for (var i = 1; i <= array.length; i++) {
						list += "<div style='width:70%;height:70px;background-color:#f9f9f9;border:2px solid #01A185;border-radius:10px;'>"
								+ "<p style='float:left;width:25%;height:100%;border-right:1px solid grey;padding-top:10px;'>"
								+ "<span id='address-number' style='font-size:30px;'>" +
										i +
										"</span></p>"
								+ "<p style='float:left;width:50%;height:100%;border-right:1px solid grey;padding-top:20px;'>"
								+ "<span id='province'>" +
										array[i-1].province + "省  " +
										"</span>"
								+ "<span id='city'>" +
										array[i-1].city + "市  " +
										"</span><span id='detail'>" +
										array[i-1].detail + 
										"</span></p>"
								+ "<p style='float:left;width:25%;height:100%;border-right:1px solid grey;padding-top:20px;'>"
								+ "<button class='mybtn' onclick='toUpdateAddress()'>修改地址</button></p></div>";

					}
					div.innerHTML = list;
				}
			});
}

</script>

<script type="text/javascript">
	$(document).ready(showTimeLog());
</script>

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
<body style="margin:0px;padding:0px">
	<!--
	时间：2018-06-02
	描述：顶部标题模块
-->
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="index.jsp"><span>用户</span>中心</a>
			</div>
			<div class="header-right">
				<!-- Large modal -->
				<div class="selectregion">
					<button class="btn btn-primary" onclick="toShop()">积分商城</button>
					<button class="btn btn-primary" onclick="toMain()">返回首页</button>
					<button class="btn btn-primary" onclick="toKnowCredits()">了解积分</button>
				</div>

			</div>
		</div>
	</div>
	<!--
     时间：2018-06-02
    描述：了解积分弹出层
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
			<h1>
				千分之累积 <span class="segment-heading"> 始于</span> 汝足下
			</h1>
		</div>
	</div>
	<!-- Products -->
	<div style="width: 100%;">
		<ul id="myTab" class="nav nav-tabs nav-tabs-responsive" role="tablist">
			<li role="presentation" class="active"><a href="#home"
				id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
				aria-expanded="true"> <span class="text">功能列表</span>
			</a></li>
		</ul>
	</div>


	<!--
                        	作者：offline
                        	时间：2018-06-02
                        	描述：记录内容模块
                        -->
	<div id="myTabContent" class="tab-content"
		style="width: 300px; height: 450px;">
		<div role="tabpanel" class="tab-pane fade in active" id="home"
			aria-labelledby="home-tab">
			<div>
				<div id="container">
					<ul class="list">

						<div id="left-use" class="left-select-div">
							<a href="javascript:;" , onClick="showTimeLog()">
								<li><img src="images/study.jpg" title="" alt="" />
									<section class="list-left">
										<h5 class="title">使用记录</h5>
										<!--<span class="adprice"></span>-->
									</section>
									<div class="clearfix"></div></li>
							</a>
						</div>

						<div id="left-change" class="left-select-div">
							<a href="javascript:;" , onClick="showChangeLog()">
								<li><img src="images/task.jpg" title="" alt="" />
									<section class="list-left">
										<h5 class="title">兑换记录</h5>
										<!--<span class="adprice"></span>-->
									</section>
									<div class="clearfix"></div></li> <a />
						</div>

						<div id="left-pwd" class="left-select-div">
							<a href="javascript:;">
								<li><img src="images/task.jpg" title="" alt="" />
									<section class="list-left">
										<h5 class="title">修改密码</h5>
										<!--<span class="adprice"></span>-->
									</section>
									<div class="clearfix"></div></li> <a />
						</div>
						
						<div id="left-address" class="left-select-div">
							<a href="javascript:;" , onClick="showAddress()">
								<li><img src="images/task.jpg" title="" alt="" />
									<section class="list-left">
										<h5 class="title">管理地址</h5>
										<!--<span class="adprice"></span>-->
									</section>
									<div class="clearfix"></div></li> <a />
						</div>
					</ul>
				</div>
			</div>
			<!-- 
			</div>
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
		</div>
 -->
		</div>
	</div>

	<div id="right" align="center"
		style="position: absolute; top: 388px; left: 300px; width: 80%; height: 450px; float: right;">
		<!--
                <div id="myTabContent" class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="home"
						aria-labelledby="home-tab">
						<button>dsahidafa</button>
					</div>
				</div>
				-->
		<!--
                	作者：hdd
                	时间：2018-06-06
                	描述：使用记录模块
                -->
		<div id="time-log-content" class="right-content">
			<p>使用记录</p>
			<hr />
			<div id="useLog">
				<!-- 迭代div标签 -->
			</div>
		</div>
		<!--
                	作者：hdd
                	时间：2018-06-06
                	描述：兑换记录模块
                -->
		<div id="change-log-content" class="right-content">
			<p>兑换记录</p>
			<hr />
			<div id="changeLog">
				<!-- 迭代标签 -->
			</div>
		</div>
		<!--
                	作者：hdd
                	时间：2018-06-06
                	描述：修改密码模块
                -->
		<div id="update-pwd-content" class="right-content" align="center">
			<div align="center" style="margin-top: 15px;">
				<h3>修改密码</h3>
				<hr />
				<table style="border-collapse: separate; border-spacing: 0px 30px;">
					<tr>
						<td>旧密码：</td>
						<td><input id="oldPwd" type="password" /><p id="oldPwdMsg"></p></td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td><input id="newPwd" type="password" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="rePwd" type="password" /><p id="rePwdMsg"></p></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button id="update-pwd-btn" class="mybtn" onClick="changePwd()">修改密码</button>
						</br><p id="changeMsg"></p></td>
					</tr>
				</table>
			</div>
		</div>
		<!--
                	作者：hdd
                	时间：2018-06-07
                	描述：管理地址模块
                -->
		<div id="update-address-content" class="right-content" align="center">
			<span>管理地址</span>		
			<button id="add-address" onclick="toAddAddress()" >添加地址</button><hr/>
			<!-- 以下为地址显示模块 -->
			<div id="addressDiv">
				<!-- 以下为迭代标签 -->
				
			</div>
	</div>
	<!-- 
		添加地址弹出窗口模块(默认隐藏)
	 -->
	<div id="add-address-box">
		<table style="border-collapse: separate; border-spacing: 0px 30px;">
			<tr>
				<td>省份:</td>
				<td>
					<select id="add-new-province">
						<option value="湖北" selected>湖北</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="黑龙江">黑龙江</option>
						<option value="吉林">吉林</option>
						<option value="辽宁">辽宁</option>
						<option value="内蒙古">内蒙古</option>
						<option value="河北">河北</option>
						<option value="新疆">新疆</option>
						<option value="甘肃">甘肃</option>
						<option value="青海">青海</option>
						<option value="陕西">陕西</option>
						<option value="宁夏">宁夏</option>
						<option value="河南">河南</option>
						<option value="山东">山东</option>
						<option value="山西">山西</option>
						<option value="安徽">安徽</option>
						<option value="湖南">湖南</option>
						<option value="江苏">江苏</option>
						<option value="四川">四川</option>
						<option value="贵州">贵州</option>
						<option value="云南">云南</option>
						<option value="广西">广西</option>
						<option value="西藏">西藏</option>
						<option value="浙江">浙江</option>
						<option value="江西">江西</option>
						<option value="广东">广东</option>
						<option value="福建">福建</option>
						<option value="台湾">台湾</option>
						<option value="海南">海南</option>
						<option value="香港">香港</option>
						<option value="澳门">澳门</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>市:</td>
				<td><input type="text" id="add-new-city"></td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td><input type="text" id="add-new-detail"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="addNewAddress" class="mybtn" onClick="addAddress()">添加地址</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- 
		修改地址弹出窗口模块(默认隐藏)
	 -->
	<div id="update-address-box" >
		<table style="border-collapse: separate; border-spacing: 0px 30px;">
			<tr>
				<td>省份:</td>
				<td>
					<select id="update-new-province">
						<option value="湖北" selected>湖北</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="黑龙江">黑龙江</option>
						<option value="吉林">吉林</option>
						<option value="辽宁">辽宁</option>
						<option value="内蒙古">内蒙古</option>
						<option value="河北">河北</option>
						<option value="新疆">新疆</option>
						<option value="甘肃">甘肃</option>
						<option value="青海">青海</option>
						<option value="陕西">陕西</option>
						<option value="宁夏">宁夏</option>
						<option value="河南">河南</option>
						<option value="山东">山东</option>
						<option value="山西">山西</option>
						<option value="安徽">安徽</option>
						<option value="湖南">湖南</option>
						<option value="江苏">江苏</option>
						<option value="四川">四川</option>
						<option value="贵州">贵州</option>
						<option value="云南">云南</option>
						<option value="广西">广西</option>
						<option value="西藏">西藏</option>
						<option value="浙江">浙江</option>
						<option value="江西">江西</option>
						<option value="广东">广东</option>
						<option value="福建">福建</option>
						<option value="台湾">台湾</option>
						<option value="海南">海南</option>
						<option value="香港">香港</option>
						<option value="澳门">澳门</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>市:</td>
				<td><input type="text" id="update-new-city"></td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td><input type="text" id="update-new-detail"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="mybtn">修改地址</button>
				</td>
			</tr>
		</table>
	</div>

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
							<li>yayaya</li>
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

	</footer>
	<!--footer section end-->
</body>
</html>