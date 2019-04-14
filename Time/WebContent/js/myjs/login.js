function login() {
	var uName = $("#username").val();
	var uPwd = $("#password").val();
	var uType = $("input[name='utype']:checked").val();
	var urlStr = "";
	var dataStr = "";
	if (uType == 2) {
		urlStr = "http://localhost:8080/Time/loginRegister/loginUser";
		dataStr = JSON.stringify({
			'uName' : uName,
			'uPwd' : uPwd
		});
	} else {
		urlStr = "http://localhost:8080/Time/loginRegister/loginManager";
		dataStr = JSON.stringify({
			'mName' : uName,
			'mPwd' : uPwd
		});
	}
	$.ajax({
		url : urlStr,
		type : "post",
		xhrFields : {
			withCredentials : true
		},
		crossDomain : true,
		contentType : "application/json",
		dataType : "json",
		data : dataStr,
		success : function(result) {
			if (result != null) {
				if (result.rType == 2) {
					window.location.href = "main.jsp";
				} else {
					window.location.href = "manager.jsp";
				}
			} else {
				alert("用户名或密码错误");
			}
		}
	});
}

function register() {
	var uName = $("#luname").val();
	var uPwd = $("#lpwd").val();
	$.ajax({
		url : "http://localhost:8080/Time/loginRegister/insertUser",
		type : "post",
		xhrFields : {
			withCredentials : true
		},
		crossDomain : true,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			'uName' : uName,
			'uPwd' : uPwd
		}),
		success : function(result) {
			if (result == 1) {
				alert("注册成功");
			} else {
				alert("注册失败");
			}
		}
	});
}

function qrlogin() {
	// 接收uuid
	var uuidQR = "";
	$
			.ajax({
				url : "http://localhost:8080/Time/login/index",
				type : "get",
				xhrFields : {
					withCredentials : true
				},
				crossDomain : true,
				success : function(result) {

					if (result != null) {
						uuidQR = result;

						// 向服务器发起开启轮询验证通知， 第一波验证二维码被扫状态
						$
								.ajax({
									url : "http://localhost:8080/Time/login/validate",
									type : "get",
									xhrFields : {
										withCredentials : true
									},
									crossDomain : true,
									data : {
										uuid : uuidQR,
									},
									success : function(res) {
										// alert("validate111"+res.state);
										var state = res.state;
										$("#msg").html('');
										if (state == -3) {
											$("#msg").append("二维码已经失效");
										} else if (state == 1) {
											$("#msg").append("请在手机上确认登录");
											// alert("请在手机上确认登录");
											// 第二波验证登录状态
											$
													.ajax({
														url : "http://localhost:8080/Time/login/validate",
														type : "get",
														data : {
															uuid : uuidQR,
														},
														success : function(res) {
															var state = res.state;
															$("#msg").html('');
															if (state == -3) {
																$("#msg")
																		.append(
																				"二维码已经失效");
															}
															if (state == 2) {
																$("#msg")
																		.append(
																				"登录成功，正在跳转。。。");
																var id = res.id;
																// 登录，跳转
																$
																		.ajax({
																			url : "http://localhost:8080/Time/loginRegister/loginByQR/"
																					+ id,
																			type : "post",
																			xhrFields : {
																				withCredentials : true
																			},
																			crossDomain : true,
																			contentType : "application/json",
																			success : function(
																					result) {
																				if (result != null) {
																					if (result.rType == 2) {
																						window.location.href = "main.jsp";
																					} else {
																						window.location.href = "manager.jsp";
																					}
																				} else {
																					alert("登陆失败");
																				}
																			}
																		});
															} else if (state == -2) {
																$("#msg")
																		.append(
																				"取消登录");
															}
														}
													});
										}
									}
								});

						// 弹窗
						var imgdiv = document.getElementById("qrlogin_box");
						var lmgurl = "http://localhost:8080/Time/login/code/"
								+ uuidQR;
						var image = "<p align='center' style='font-size: 23px; color: #FF9E29'>Time</p>"
								+ "<img alt='' src='"
								+ lmgurl
								+ "'/>"
								+ "<p id='msg' align='center' style='font-size: 23px; color: #FF9E29'>请用手机扫描</p>";
//								+ "<button  class='btn_sign_up' onClick='closeQR()'>取消</button>";
						imgdiv.innerHTML = image;
						layer.open({
							type : 1,
							title : "扫码登录",
							skin : 'layui-layer-molv',
							area : [ "300px", "400px" ],
							content : $("#qrlogin_box")
						});

					}
				}
			});

}


function cambiar_login() {

	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
	document.querySelector('.cont_form_login').style.display = "block";
	document.querySelector('.cont_form_sign_up').style.opacity = "0";
	document.getElementById('erweima').style.display = "none";
	document.getElementById('a1').style.display = "block";

	setTimeout(function() {
		document.querySelector('.cont_form_login').style.opacity = "1";
	}, 400);

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.display = "none";
	}, 200);
}

function cambiar_login2() {
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
	document.querySelector('.cont_form_login2').style.display = "block";
	document.querySelector('.cont_form_sign_up').style.opacity = "0";
	document.getElementById('erweima').style.display = "block";

	document.getElementById('a1').style.display = "none";

	setTimeout(function() {
		document.querySelector('.cont_form_login').style.opacity = "1";
	}, 400);

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.display = "none";
	}, 200);

}

function cambiar_sign_up(at) {
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
	document.querySelector('.cont_form_sign_up').style.display = "block";
	document.querySelector('.cont_form_login2').style.display = "none";
	document.querySelector('.cont_form_login').style.opacity = "0";

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.opacity = "1";
	}, 100);

	setTimeout(function() {
		document.querySelector('.cont_form_login').style.display = "none";
	}, 400);

}

function ocultar_login_sign_up() {

	document.querySelector('.cont_forms').className = "cont_forms";
	document.querySelector('.cont_form_sign_up').style.opacity = "0";
	document.querySelector('.cont_form_login').style.opacity = "0";

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.display = "none";
		document.querySelector('.cont_form_login').style.display = "none";
	}, 500);

}

function ocultar_login_sign_up2() {
	alert(2);
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
	document.querySelector('.cont_form_login2').style.display = "block";
	document.querySelector('.cont_form_sign_up').style.opacity = "0";
	document.getElementById('erweima').style.display = "block";

	document.getElementById('a1').style.display = "none";

	setTimeout(function() {
		document.querySelector('.cont_form_login').style.opacity = "1";
	}, 400);

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.display = "none";
	}, 200);

}
