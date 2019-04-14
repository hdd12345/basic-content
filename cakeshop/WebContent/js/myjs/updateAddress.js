$(document).ready(function(){
	var flag = true;//用于判断ajax是否提交
	$("#update").on("click",function(){
		
		var name = $("#name").val();//收货人姓名
		var telephone = $("#telephone").val();//电话
		var postcode = $("#postcode").val();//邮编
		var address_content = $("#address_content").val();//地址
		
       
       //以下为表单校验
       if(name==""){
    	   flag=false;
    	   layer.tips('收货人姓名不能为空！', '#name',{tipsMore: true});
       }
       if(telephone==""){
    	   flag=false;
    	   layer.tips('电话不能为空！', '#telephone',{tipsMore: true});
       }
       if(postcode==""){
    	   flag=false;
    	   layer.tips('邮编不能为空！', '#postcode',{tipsMore: true});
       }
       if(address_content==""){
    	   flag=false;
    	   layer.tips('地址不能为空！', '#address_content',{tipsMore: true});
       }
       //更新请求
       var address_id = $("#address_id").val();
       if(flag){
    	   $.ajax({
      			url:"http://localhost:8080/cakeshop/address/updateAddress",
      			type:"post",
      			contentType :"application/json",
      			data:JSON.stringify({
      				"name":name,
      				"telephone":telephone,
      				"postcode":postcode,
      				"address_content":address_content,
      				"address_id":address_id
      			}),
      			success:function(data){
      				
      				if(data>0){
      					window.location.href="http://localhost:8080/cakeshop/address.jsp";
      				}else{
      					alert(data);
      				}
      			},
      			error:function(data){
      				alert("更新失败！");
      			}
      		});
       }
	});
});