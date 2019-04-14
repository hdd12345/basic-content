function toKnowCredits() {
	// layer.alert("哈哈哈");
	layer.open({
		type : 1,
		title : "了解积分",
		skin : 'layui-layer-molv',
		area : [ "300px", "400px" ],
		content : $("#know-credits-box")
	});
}

function toMain() {
	window.location.href = "main.jsp";
}

function toShop() {
	window.location.href = "shop.jsp";
}

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
})

function datetimeFormat_1(longTypeDate) {
	var datetimeType = "";
	var date = new Date();
	date.setTime(longTypeDate);
	datetimeType += date.getFullYear(); // 年
	datetimeType += "-" + getMonth(date); // 月
	datetimeType += "-" + getDay(date); // 日
	datetimeType += "  " + getHours(date); // 时
	datetimeType += ":" + getMinutes(date); // 分
	datetimeType += ":" + getSeconds(date); // 分
	return datetimeType;
}
// 返回 01-12 的月份值
function getMonth(date) {
	var month = "";
	month = date.getMonth() + 1; // getMonth()得到的月份是0-11
	if (month < 10) {
		month = "0" + month;
	}
	return month;
}
// 返回01-30的日期
function getDay(date) {
	var day = "";
	day = date.getDate();
	if (day < 10) {
		day = "0" + day;
	}
	return day;
}
// 返回小时
function getHours(date) {
	var hours = "";
	hours = date.getHours();
	if (hours < 10) {
		hours = "0" + hours;
	}
	return hours;
}
// 返回分
function getMinutes(date) {
	var minute = "";
	minute = date.getMinutes();
	if (minute < 10) {
		minute = "0" + minute;
	}
	return minute;
}
// 返回秒
function getSeconds(date) {
	var second = "";
	second = date.getSeconds();
	if (second < 10) {
		second = "0" + second;
	}
	return second;
}

function addAddress() {
	$.ajax({
		url : "http://localhost:8080/Time/user/addAddress",
		type : "post",
		xhrFields : {
			withCredentials : true
		},
		crossDomain : true,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			'uId' : "${user.uId}",
			'province' : $("#add-new-province").val(),
			'city' : $("#add-new-city").val(),
			'detail' : $("#add-new-detail").val()
		}),
		success : function(result) {
			if (result == 1) {
				alert("添加成功");
			} else {
				alert("添加失败");
			}
		}
	});
}