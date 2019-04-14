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
							content+="<li><a class='list' href='javascript:getCurrentData("+min[j].min_id+",1);'>"+min[j].min_name+"</a></li>";
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
	
	//加载单页数据
	getCurrentData(1,1);
	
});

//底部分页图标监听
function hhh(min_id,currentPage){
	$.ajax({
		url:"http://localhost:8080/cakeshop/goods/getGoodsByMin_id",
		type:"post",
		data:"min_id="+min_id+"&currentPage="+currentPage,
		dataType:"json",
		success:function(result){
			var pageBean = result;
			var goodsList = pageBean.list;
			var content = "";
			for(var i=0;i<goodsList.length;i++){
				content+="<div class='product-grid' style='height:350px;'>"
					     +"<a href='productInfo.jsp?goods_id="
					     +goodsList[i].goods_id+"'>"				
						 +"<div class='more-product'><span> </span></div>"						
						 +"<div class='product-img b-link-stripe b-animate-go  thickbox'>"
						 +"<img src='images/"
						 +goodsList[i].gimage+"' class='img-responsive' alt=''>"
						 +"<div class='b-wrapper'>"
						 +"<h4 class='b-animate b-from-left  b-delay03'>"							
						 +"<button>View</button></h4></div></div></a>"				
					     +"<div class='product-info simpleCart_shelfItem'>"
						 +"<div class='product-info-cust prt_name'>"
						 +"<h4>"
						 +goodsList[i].gname+"</h4>"								
						 +"<span class='item_price'>"
						 +goodsList[i].gprice+"</span>"
						 +"<div class='ofr'><p class='pric1'><del></del></p>"
						 +"<p class='disc'></p></div>"
						 +"<input type='text' class='item_quantity' value='1' />"
						 +"<input type='button' class='item_add items' value='添加'>"
						 +"<div class='clearfix'></div></div></div></div>";
			}
			$("#product-box").html(content);
			$("#myli li").removeClass("active");
			$("#myli li").eq(currentPage-1).addClass("active");
		},
		error:function(result){
			
		}
	});
}

//分类监听
function getCurrentData(min_id,currentPage){
	//获取当前分类单页商品
	$.ajax({
		url:"http://localhost:8080/cakeshop/goods/getGoodsByMin_id",
		type:"post",
		data:"min_id="+min_id+"&currentPage="+currentPage,
		dataType:"json",
		success:function(result){
			var pageBean = result;
			var goodsList = pageBean.list;
			var content = "";
			for(var i=0;i<goodsList.length;i++){
				content+="<div class='product-grid' style='height:350px;'>"
					     +"<a href='productInfo.jsp?goods_id="
					     +goodsList[i].goods_id+"'>"				
						 +"<div class='more-product'><span> </span></div>"						
						 +"<div class='product-img b-link-stripe b-animate-go  thickbox'>"
						 +"<img src='images/"
						 +goodsList[i].gimage+"' class='img-responsive' alt=''>"
						 +"<div class='b-wrapper'>"
						 +"<h4 class='b-animate b-from-left  b-delay03'>"							
						 +"<button>View</button></h4></div></div></a>"				
					     +"<div class='product-info simpleCart_shelfItem'>"
						 +"<div class='product-info-cust prt_name'>"
						 +"<h4>"
						 +goodsList[i].gname+"</h4>"								
						 +"<span class='item_price'>"
						 +goodsList[i].gprice+"</span>"
						 +"<div class='ofr'><p class='pric1'><del></del></p>"
						 +"<p class='disc'></p></div>"
						 +"<input type='text' class='item_quantity' value='1' />"
						 +"<input type='button' class='item_add items' value='添加'>"
						 +"<div class='clearfix'></div></div></div></div>";
			}
			$("#product-box").html(content);
			//设置底部分页图标
			var totalPage = pageBean.totalPage;
			var currentPage = pageBean.currentPage;
			var min_id = pageBean.list[0].min_id;
			var div = document.getElementById("myli");
			var pagecontent = "";
			for(var i=1;i<=totalPage;i++){
				pagecontent+="<li><a href='javascript:hhh("+min_id+","+i+");'>"+i+"</a></li>";
			}
			div.innerHTML=pagecontent;
			$("#myli li").eq(currentPage-1).addClass("active");
		},
		error:function(result){
			
		}
	});
}