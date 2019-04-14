$(document).ready(function(){  
	  $.ajax({
			url:"http://localhost:8080/cakeshop/address/selectAddress",
			type:"post",
			data:"userId="+1,
			dataType:"json",
			success:function(data){
					var div = document.getElementById("address");
					arr = data;
					var content="<table width='50%' height='50%'><tr><th align='center'>姓名</th><th align='center'>电话</th><th align='center'>邮编</th><th align='center'>地址</th><th align='center'></th></tr>";
				for(var i=0;i<arr.length;i++){
					content+="<tr><td align='left'>"
					+arr[i].name+"</td><td align='left'>"
					+arr[i].telephone+"</td><td align='left'>"
					+arr[i].postcode+"</td><td align='left'>"
					+arr[i].address_content+"</td><td>"
					+"<td><a href='http://localhost:8080/cakeshop/updateAddress.jsp?address_id="+arr[i].address_id+"'>修改</a>|<a href='http://localhost:8080/cakeshop/address/deleteAddress?addressId="+arr[i].address_id+"'>删除</a></div></td></tr>"
					;
					
				}
				content+="</table>"
				div.innerHTML=content;
				
			},
			error:function(data){
				alert("页面加载失败请刷新页面！");
			}
		});
});
					

					

					

					
				

					
					
					

					
					

		
	  
	  
	  
/* $.ajax({
		url:"http://localhost:8080/shop/hotProduct",
		type:"get",
		data:"",
		dataType:"json",
		success:function(result){
			var div = document.getElementById("hotProduct");
			var content = "<div class='col-md-6' style='text-align:center;height:200px;padding:0px;'>"
						+"<a href='product_info.jsp'>"
						+"<img src='products/hao/middle01.jpg' width='516px' height='200px' style='display: inline-block;'>"
						+"</a></div>";
			arr = result;
			for(var i=0;i<arr.length;i++){
				content+="<div class='col-md-2' style='text-align:center;height:200px;padding:10px 0px;'>"
						+"<a href='product_info.jsp?pid="
						+arr[i].pid						
						+"'><img src='"
						+arr[i].pimage
						+"' width='130' height='130' style='display: inline-block;'>"
						+"</a><p><a href='product_info.jsp?pid="
						+arr[i].pid
						+"' style='color:#666'>"
						+arr[i].pname
						+"</a></p>"
						+"<p><font color='#E4393C' style='font-size:16px'>&yen;"
						+arr[i].shop_price
						+"</font></p></div>";				
			}
			div.innerHTML=content;
		},
		error:function(result){
			alert("请求数据失败，请尝试刷新页面！");
		}
	});
});

*/




