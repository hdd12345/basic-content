<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册</title>
<link rel="stylesheet" href="css/login-style.css">
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script src="js/myjs/login.js"></script>
<body>

	<div class="cotn_principal">
		<div class="cont_centrar">
			<div class="cont_login">
				<div class="cont_info_log_sign_up">
					<div class="col_md_login">
						<div class="cont_ba_opcitiy">
							<h2>登录</h2>
							<p>登录个人中心</p>
							<button class="btn_login" onClick="cambiar_login()">登录</button>
							<button class="btn_login" onClick="qrlogin()">扫码登录</button>
						</div>
					</div>
					<div class="col_md_sign_up">
						<div class="cont_ba_opcitiy">
							<h2>注册</h2>
							<p>注册用户信息</p>
							<button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
						</div>
					</div>
				</div>
				<div class="cont_back_info">
					<div class="cont_img_back_grey">
						<img src="images/po.jpg" alt="" />
					</div>
				</div>
				<div class="cont_forms">
					<div class="cont_img_back_">
						<img src="images/po.jpg" alt="" />
					</div>


					<div class="cont_form_login">
						<a href="#" onClick="ocultar_login_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<table id="a1">
							<h2>LOGIN</h2>
							<input id="username" type="text" placeholder="UserName" />
							<input id="password" type="password" placeholder="Password" />
							<button class="btn_login" onClick="login()">登录</button>
							<input type="radio" checked="checked" name="utype" value="2">用户
							<input type="radio" name="utype" value="1">管理员
							<br />
						</table>

					</div>


					<div class="cont_form_login2">
						<a href="#" onClick="ocultar_login_sign_up2()"></a>

						<div id="erweima" style="display: none;">
							<a href="#" onClick="ocultar_login_sign_up2()"></a> <img
								src="images/20180601085545.png" alt="" />
						</div>


					</div>



					<div class="cont_form_sign_up">
						<a href="#" onClick="ocultar_login_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>注册中心</h2>
						<input type="text" placeholder="Email" /> <input id="luname"
							type="text" placeholder="User" /> <input id="lpwd"
							type="password" placeholder="Password" /> <input type="password"
							placeholder="Confirm Password" />
						<button class="btn_sign_up" onClick="register()">注册</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!--
    	时间：2018-06-05
    	描述：扫码登录弹出窗口
    -->
	<div id="qrlogin_box" style="display: none;">

	</div>

</body>
</html>
