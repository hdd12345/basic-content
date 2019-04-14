$(document).ready(function(){
	var flag = true;//用于判断ajax是否提交
	$("#register").on("click",function(){
		
		var username = $("#username").val();//用户名
		var password = $("#password").val();//密码
		var email = $("#email").val();//邮箱
		var name = $("#name").val();//姓名
		var confirmPassword = $("#confirmPassword").val();//确认密码
		var telephone = $("#telephone").val();//手机号
		var validateCode = $("#validateCode").val();//验证码
		//获取性别
		var radio=document.getElementsByName("sex");
        var sex=null;
        for(var i=0;i<radio.length;i++){
              if(radio[i].checked==true) {
                       sex=radio[i].value;
                       break;
             }
       }
       //以下为表单校验
       if(username==""){
    	   flag=false;
    	   layer.tips('用户名不能为空！', '#username',{tipsMore: true});
       }
       if(name==""){
    	   flag=false;
    	   layer.tips('姓名不能为空！', '#name',{tipsMore: true});
       }
       if(password==""){
    	   flag=false;
    	   layer.tips('密码不能为空！', '#password',{tipsMore: true});
       }
       if(confirmPassword==""){
    	   flag=false;
    	   layer.tips('确认密码不能为空！', '#confirmPassword',{tipsMore: true});
       }
       if(email==""){
    	   flag=false;
    	   layer.tips('邮箱不能为空！', '#email',{tipsMore: true});
       }
       if(telephone==""){
    	   flag=false;
    	   layer.tips('手机号不能为空！', '#telephone',{tipsMore: true});
       }
       if(validateCode==""){
    	   flag=false;
    	   layer.tips('验证码不能为空！', '#validateCode',{tipsMore: true});
       }
       
       //验证验证码
       $.ajax({
    	   url:"http://localhost:8080/cakeshop/user/validate",
    	   type:"post",
    	   cache:false,
    	   async:false,
    	   data:"word="+$("#validateCode").val(),
    	   success:function(result){
    		   if(result==0){
    			   flag=false;
    			   layer.tips('验证码不正确！', '#validateCode',{
						tips: [1, '#FF6666'],
						  time: 2000,
						tipsMore: true});
    		   }else{
    			   flag=true;
    		   }
    	   }
       });
       //注册请求
       if(flag){
    	   $.ajax({
      			url:"http://localhost:8080/cakeshop/user/register",
      			type:"post",
      			contentType :"application/json",
      			data:JSON.stringify({
      				"username":username,
      				"password":password,
      				"email":email,
      				"name":name,
      				"sex":sex,
      				"telephone":telephone
      			}),
      			success:function(data){
      				if(data>0){
      					layer.open({
      						type : 1,
      						title : "账户激活",
      						skin : 'layui-layer-molv',
      						area : [ "380px", "260px" ],
      						content : $("#active-box")
      				      });
      				}else{
      					alert("注册失败！");
      				}
      			},
      			error:function(data){
      				alert("注册失败！");
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
	
	//检验用户名是否存在
	$("#username").blur(function(){
		$.ajax({
			url:"http://localhost:8080/cakeshop/user/checkUsername",
			type:"get",
			data:"username="+$("#username").val(),
			success:function(data){
				if(data>0){
					flag=false;
					layer.tips('用户名已存在！', '#username', {
						tips: [1, '#FF6666'],
						  time: 1000,
						tipsMore: true});	
				}else{
					flag=true;
				}
			},
			error:function(data){
				alert("请求失败！");
			}
		});
	});
	
	//切换验证码
	$("#translate").on("click",function(){
		var div = document.getElementById("translate");
		div.innerHTML = "<img src='http://localhost:8080/cakeshop/user/validateCode.jpg'/>";
	});
	
	//激活监听
	$("#active").on("click",function(){
		$.ajax({
			url:"http://localhost:8080/cakeshop/user/active",
			type:"post",
			data:"activeCode="+$("#activeCode").val(),
			success:function(data){
				if(data>0){
					alert("激活成功！请前往首页登录！");
					window.location.href="http://localhost:8080/cakeshop/index.jsp";
				}else{
					alert("激活失败！")
				}
			},
			error:function(data){
				alert("激活失败");
			}
		});
	});
	
	
});