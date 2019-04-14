$(document).ready(function(){
	loading();
	
	
	
});

//加载数据
function loading(){
	$.ajax({
		url:"http://localhost:8080/cakeshop/goods/selectGoods",
		type:"post",
		dataType:"json",
		data:"goods_id="+$("#goods_id").val(),
		success:function(result){
			var content = "";
			content+="<h3>"
					+result.gname+"</h3>"
					+"<p>"
					+result.gdesc+"</p>"
					+"<div class='galry'>"
					+"<div class='prices'>"
					+"<h5 class='item_price'>"
					+result.gprice+"</h5>"
					+"</div><div class='rating'><span>☆</span><span>☆</span>"
					+"<span>☆</span><span>☆</span><span>☆</span></div>"
					+"<div class='clearfix'></div>"
					+"</div>"
					+"<p class='qty'>"
					+"</p><input min='1' type='number' id='quantity' name='quantity' value='1' class='form-control input-small'>"
					+"<div class='btn_form'>"
					+"<a href='javascript:addCart();' class='add-cart item_add'>加入购物车</a></div>";
			$("#goodsInfo").html(content);
			var imgg = " <img src='images/"+result.gimage+"' data-imagezoom='true' class='img-responsive'> ";
			$("#goodsImg").html(imgg);
		},
		error:function(result){
			
		}
	});
}


//加入购物车监听
function addCart(){
	var goods_id = $("#goods_id").val();
	var quantity = $("#quantity").val();
	$.ajax({
		url:"http://localhost:8080/cakeshop/cart/addCartitem",
		type:"post",
		data:{
			"goods_id":goods_id,
			"quantity":quantity
		},
		success:function(result){
			if(result>0){
				alert("已加入购物车！");
			}else if(result==-1){
				alert("请先登录！");
			}else{
				alert("添加失败！");
			}
		},
		error:function(result){
			
		}
	});
}



