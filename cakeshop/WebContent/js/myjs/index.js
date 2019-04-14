$(document).ready(function(){
	//加载二级分类菜单
	$.ajax({
		url:"http://localhost:8080/cakeshop/goods/maxcategory",
		type:"post",
		data:"",
		success:function(result){
			var maxul = document.getElementById("category");
			var max = result;
			var content = "<li><a href='index.jsp' class='active'>首页</a></li>";
			for(var i=0;i<max.length;i++){
				content += "<li class='dropdown'>"
						  +"<a href='#' class='dropdown-toggle' data-toggle='dropdown'>"
						  +max[i].max_name
						  +"<b class='caret'></b></a>"
						  +"<ul class='dropdown-menu multi-column columns-4'>"
						  +"<div class='row'>"
						  +"<div class='col-sm-3'>"			
						  +"<ul class='multi-column-dropdown'>";
				var max_id=max[i].max_id;
				$.ajax({
					url:"http://localhost:8080/cakeshop/goods/mincategory",
					type:"post",
					async: false,//此处只能为同步请求，否则页面加载不完整
					data:"max_id="+max_id,
					success:function(data){
						var min = data;
						for(var j=0;j<min.length;j++){
							content+="<li><a class='list' href='products.jsp'>"+min[j].min_name+"</a></li>";
						}	
					}
				});
				content+="</ul></div></div></ul></li>";
			}
			maxul.innerHTML=content;
		},
		error:function(result){
			alert("请求数据失败，请尝试刷新页面！");
		}
	});
	
	//加载页面数据
	loading();
});

function loading(){
	$.ajax({
		url:"http://localhost:8080/cakeshop/goods/selectNewGoods",
		type:"post",
		data:"",
		dataType:"json",
		success:function(data){
			var div = document.getElementById("div");
			var arr = data;
			var content ="";
			for(var i=0;i<arr.length;i++){
				content+="<div class='col-md-3 gallery-grid '>"
					+"<a href='productInfo.jsp?goods_id="
					+arr[i].goods_id+"'><img src='images/"+arr[i].gimage+"' class='img-responsive' alt=''/>"
					+"<div class='gallery-info'>"
					+"<p><span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span> view</p>"
					+"<a class='shop' href='productInfo.jsp?goods_id="
					+arr[i].goods_id+"'></a>"
					+"<div class='clearfix'> </div></div></a>"
					+"<p>"+arr[i].gname+"</p>"
					+"<div class='galry'><div class='prices'><h5 class='item_price'>"+arr[i].gprice+"</h5></div>"
					+"<div class='rating'><span>☆</span><span>☆</span><span>☆</span><span>☆</span>"
					+"<span>☆</span></div><div class='clearfix'></div></div></div></div>";
			}
			
			div.innerHTML=content;
		},
		error:function(data){
			alert("请求数据失败，请尝试刷新页面！");
		}
	});

}