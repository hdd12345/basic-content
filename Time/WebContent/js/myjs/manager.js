function addgoods() {
	var gType = $("#category").val();
	var gName = $("#gname").val();
	var gNum = $("#gnum").val();
	var gCount = $("#gCount").val();
	var gConsume = $("#gConsume").val();
	var gIcon = $("#gIcon").val();
	$.ajax({
		url : "http://localhost:8080/Time/manager/addGoods",
		type : "post",
		xhrFields : {
			withCredentials : true
		},
		crossDomain : true,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			'gType' : parseInt(gType),
			'gName' : gName,
			'gNum' : gNum,
			'gCount' : parseInt(gCount),
			'gConsume' : parseInt(gConsume),
			'gIcon' : gIcon
		}),
		success : function(result) {
			if (result == 1) {
				alert("提交成功");

			} else {
				alert("用户名或密码错误");
			}
		}
	});
}

function goodsTypeList() {
	$
			.ajax({
				url : "http://localhost:8080/Time/goods/allGoodsType",
				type : "post",
				xhrFields : {
					withCredentials : true
				},
				crossDomain : true,
				dataType : "json",
				success : function(result) {
					if (result != null) {
						var select = document.getElementById("category");
						var array = new Array();
						array = result;
						for (var i = 0; i < array.length; i++) { // 循环添加多个option
							var varItem = new Option(array[i].typeName,
									array[i].gType);
							select.options.add(varItem);
						}
					}
				}
			});
}
