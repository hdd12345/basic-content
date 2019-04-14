$(document).ready(function(){
	$("#login").on("click",function(){
		var flag = true;
		var username = $("#username").val();
		var password = $("#password").val();
		if(username==""){
			flag=false;
			layer.tips('用户名不能为空！', '#username',{tipsMore: true});
		}
		if(password==""){
			flag=false;
			layer.tips('密码不能为空！', '#password',{tipsMore: true});
		}	
		if(flag){
			$.ajax({
				url:"http://localhost:8080/cakeshop/user/login",
				type:"post",
				contentType:"application/json",
				data:JSON.stringify({
					"username":username,
					"password":password
				}),
				success:function(result){
					if(result==1){
						window.location.href="http://localhost:8080/cakeshop/index.jsp";
					}else{
						layer.msg("用户名或密码错误！");
					}
				},error:function(result){
					alert("哎呀出bug了");
				}
			});
		}
	});	
});
