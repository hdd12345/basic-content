$(document).ready(function(){
	$.ajax({
		url:"http://localhost:8080/cakeshop/orders/getOrders",
		data:"user_id="+$("#user_id").val(),
		dataType:"json",
		success:function(result){
			var arr = result;
			var hhh = arr[0].list[0].goods.gname;
			var content = "";
			for(var i=0;i<arr.length;i++){
				content+="<div ><div class='max-spl'></div>"
						+"<div class='dede'>"
    			        +"<p>订单号："+arr[i].orders_num+"</p>"
    			        +"<p>时间："+arr[i].orders_time+"</p>"
    			        +"<p>状态："+arr[i].orders_state+"</p>"
    			        +"<p>总价："+arr[i].orders_total_price+"</p></div>";
				var ordersInfoList = arr[i].list;
//				alert(ordersInfoList[0].goods.gname);
				for(var j=0;j<ordersInfoList.length;j++){
					var goods = ordersInfoList[j].goods;
					content+="<div class='ordersitem'><div class='hhhhh'>"
							+"<p>商品名称："+goods.gname+"</p>"
							+"<p>购买数量："+ordersInfoList[j].quantity+"</p>"
							+"<p>价格："+ordersInfoList[j].total_price+"</p>"
							+"</div><div class='hhhhh'>"
							+"<img class='iii' src='images/"
							+goods.gimage+"' /></div></div>";
				}
				content+="</div>";
			}
			$("#orders-box").html(content);
		},
		error:function(result){
			alert("121");
		}
	});
});

function turn(){
	window.location.href="http://localhost:8080/cakeshop/index.jsp";
}