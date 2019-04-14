$(document).ready(function(){
	var flag = true;//用于判断ajax是否提交
	$("#updatepassword").on("click",function(){
		
		var oldpassword = $("#oldpassword").val();//旧密码
		var password = $("#password").val();//密码
		
	
		var confirmPassword = $("#confirmPassword").val();//确认密码
		

	
       
       //以下为表单校验
       if(oldpassword==""){
    	   flag=false;
    	   layer.tips('旧密码不能为空！', '#oldpassword',{tipsMore: true});
       }
     
       if(password==""){
    	   flag=false;
    	   layer.tips('密码不能为空！', '#password',{tipsMore: true});
       }
       if(confirmPassword==""){
    	   flag=false;
    	   layer.tips('确认密码不能为空！', '#confirmPassword',{tipsMore: true});
       }
       
       if(flag){
     	   $.ajax({
       			url:"http://localhost:8080/cakeshop/user/updatePassword",
       			type:"post",
       			contentType :"application/json",
       			data:JSON.stringify({
       				
       				"password":password,
       				
       			}),
       			success:function(data){
       				if(data>0){
       					layer.msg("修改成功，请重新登录");
       					window.location.href="http://localhost:8080/cakeshop/index.jsp";
       				}else{
       					alert("修改失败！");
       				}
       			},
       			error:function(data){
       				alert("修改失败！");
       			}
       		});
    	}
      
	});
	//检验两次密码是否一致
	$("#confirmPassword").blur(function(){
		if($("#password").val()!=$("#confirmPassword").val()){
			flag=false;
			layer.tips('两次密码不一致！', '#confirmPassword',{tipsMore: true});
		}else{
			flag=true;
		}
	});
	//检验旧密码是否正确
	$("#oldpassword").blur(function(){
		$.ajax({
			url:"http://localhost:8080/cakeshop/user/jiami",
			data:"oldpassword="+$("#oldpassword").val(),
			type:"post",
			success:function(result){
				if(result==0){
					layer.tips('密码不正确！', '#oldpassword',{tipsMore: true});
				}
			},
			error:function(result){
				
			}
				
		});
	});
	
     

	
	
});