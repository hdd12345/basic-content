$(document).ready(function(){
	lodding();
	
	//删除购物车
	$("#delete").on("click",function(){
		var checkbox = document.getElementsByName("check");
	    var check_val = new Array();
	    for(var i=0;i<checkbox.length;i++){
	        if(checkbox[i].checked==true)
	            check_val.push(checkbox[i].value);
	    }
	    var parameter = "";
	    for(var i=0;i<check_val.length;i++){
	    	if(i==check_val.length-1){
	    		parameter+=check_val[i];
	    	}else{
	    		parameter+=check_val[i]+",";
	    	}
	    }
	    if(parameter == ""){
	    	alert("请至少选择一条");
	    }else{
	    	$.ajax({
		    	url:"http://localhost:8080/cakeshop/cart/deleteCartitem",
		    	type:"post",
		    	data:{
		    		"ids":parameter
		    	},
		    	success:function(data){
		    		if(data>0){
		    			alert("删除成功！");
		    			lodding();
		    		}else{
		    			alert("删除失败！");
		    		}
		    	},
		    	error:function(data){
		    		alert("删除失败！");
		    	}
		    });
	    }
	    
	});
});
// 加载数据
function lodding(){
	$.ajax({
		url:"http://localhost:8080/cakeshop/cart/getCartitemList",
		type:"post",
		data:"",
		dataType:"json",
		success:function(result){
			var arr = result;
			var content = "<h2>我的购物车("+arr.length+")</h2>";
			for(var i=0;i<arr.length;i++){
				var goods = arr[i].goods;
				content+="<div class='cart-header'>"
						+"<div class='close1'> <input type='checkbox' name='check' value='"
						+arr[i].cartitem_id+"'></div>"
						+"<div class='cart-sec simpleCart_shelfItem'>"
					    +"<div class='cart-item cyc'>"
						+"<img src='images/"
						+goods.gimage+"' class='img-responsive' alt=''>"
						+"</div><div class='cart-item-info'>"
						+"<h3><a href='#'>"
						+goods.gname+"</a><span></span></h3>"
						+"<ul class='qty'>"
						+"<li><p>数量："
						+arr[i].quantity+"</p></li>"
						+"<li><p></p></li>"
						+"</ul><div class='delivery'>"
						+"<p>价格:"
						+goods.gprice+"</p>"
						+"<span></span>"
						+"<div class='clearfix'></div>"
						+"</div></div><div class='clearfix'></div></div></div>";
			}
			$("#cartitem-box").html(content);
		},
		error:function(result){
			
		}
	});
}


//结算监听
function tobuy(){
	var checkbox = document.getElementsByName("check");
    var check_val = new Array();
    for(var i=0;i<checkbox.length;i++){
        if(checkbox[i].checked==true)
            check_val.push(checkbox[i].value);
    }
    var parameter = "";
    for(var i=0;i<check_val.length;i++){
    	if(i==check_val.length-1){
    		parameter+=check_val[i];
    	}else{
    		parameter+=check_val[i]+",";
    	}
    }
    if(parameter==""){
    	layer.msg("请至少选择一条！");
    }else{
    	$.ajax({
    		url:"http://localhost:8080/cakeshop/address/selectAddress",
    		type:"post",
    		data:"",
    		dataType:"json",
    		success:function(result){
    			var arr = result;
    			var content="";
    			//content = "<option selected value='"+arr[0].address_id+"'>"+arr[0].address_content+"</option>";
    			for(var i =0;i<arr.length;i++){
    				content+="<option value='"+arr[i].address_id+"'>"+arr[i].address_content+"</option>";
    			}
    			$("#my-address").html(content);
    			layer.open({
						type : 1,
						title : "请选择收货地址",
						skin : 'layui-layer-molv',
						area : [ "380px", "260px" ],
						content : $("#select-address-box")
				      });
    		},
    		error:function(result){
    			
    		}
    	});
    }
}


//购买
function buy(){
	var checkbox = document.getElementsByName("check");
    var check_val = new Array();
    for(var i=0;i<checkbox.length;i++){
        if(checkbox[i].checked==true)
            check_val.push(checkbox[i].value);
    }
    var parameter = "";
    for(var i=0;i<check_val.length;i++){
    	if(i==check_val.length-1){
    		parameter+=check_val[i];
    	}else{
    		parameter+=check_val[i]+",";
    	}
    }
    //alert($("#my-address option:selected").val());
    //"ids="+parameter+"&user_id="+$("#user_id").val()+"&address_id="+$("#my-address option:selected").val()
    $.ajax({
    	url:"http://localhost:8080/cakeshop/orders/addOrders",
    	type:"post",
    	async:false,
    	data:{
    		"ids":parameter,
    		"address_id":$("#my-address option:selected").val(),
    		"user_id":$("#user_id").val()
    	},
    	success:function(result){
    		var orders_num=result.orders_num;
    		var money=result.orders_total_price;
    		window.location.href="pay.jsp?orders_num="+orders_num+"&money="+money;
    	},
    	error:function(result){
    		
    	}
    });
}


