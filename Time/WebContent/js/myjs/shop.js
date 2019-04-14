var goodsId = "";
var goodsConsume = 0;
var userId = "";
var userCredit = 0;

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
// 显示确认兑换选择地址窗口
function toConfirmChange(gId, consume, uId, credit) {
	// 在此处添加ajax方法，取出该用户收货地址，迭代<option>标签
	// showAddress();
	goodsId = gId;
	goodsConsume = consume;
	userId = uId;
	userCredit = credit;
	alert("uId" + uId);
	alert(goodsConsume);

	layer.open({
		type : 1,
		title : "确认兑换",
		skin : 'layui-layer-molv',
		area : [ "300px", "200px" ],
		content : $("#confirm-change-box")
	});
}

function change() {
	if (userCredit >= goodsConsume) {
		var adrId = $("#select-address").val();
		$
				.ajax({
					url : "http://localhost:8080/Time/user/change",
					type : "post",
					xhrFields : {
						withCredentials : true
					},
					crossDomain : true,
					dataType : "json",
					data : {
						'uId' : userId,
						'gId' : goodsId,
						'consume' : goodsConsume,
						'adrId' : adrId
					},
					success : function(result) {
						// 刷新
						$
								.ajax({
									url : "http://localhost:8080/Time/goods/goodsList",
									type : "post",
									xhrFields : {
										withCredentials : true
									},
									crossDomain : true,
									dataType : "json",
									data : {
										'roleType' : 2
									},
									success : function(result) {
										// 输出到列表；
										var listdiv = document
												.getElementById("goodsdiv");
										var allgoods = document
												.getElementById("allgoods");
										var userId = "${user.uId}";
										var credit = "${user.credit}";
										var array = new Array();
										array = result;
										var list = "<ul id='goodslist' class='list'>";
										for (var i = 1; i <= array.length; i++) {
											list += "<a href='javascript:;'><li>"
													+ "<img src='images/m1.jpg' title='' alt='' />"
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
						alert("兑换");
					}
				});
	} else {
		alert("积分不足");
	}
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
					var div = document.getElementById("goodsTypeDiv");
					var array = new Array();
					array = result;
					var list = "<ul id='myTab' class='nav nav-tabs nav-tabs-responsive' role='tablist'>";
					list += "<li role='presentation' class='active'>"
							+ "<a href='#home' role='tab' data-toggle='tab' aria-controls='home' aria-expanded='true' onClick='goodsList(null)'>"
							+ "<span class='text'>所有商品</span></a></li>"
					for (var i = 1; i <= array.length; i++) {
						list += "<li role='presentation' class='active'>"
								+ "<a href='#home' id='"
								+ array[i - 1].gType
								+ "' role='tab' data-toggle='tab' aria-controls='home' aria-expanded='true' onClick='goodsList(this.id)'>"
								+ " <span class='text'>"
								+ array[i - 1].typeName + "</span></a></li>";
					}
					list += "</ul>"
					div.innerHTML = list;

				}

			});
}