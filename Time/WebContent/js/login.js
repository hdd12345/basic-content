function login(){
		$.ajax({
		url:"http://10.201.111.177/Time/loginRegister/loginUser",
		method:"post",
		data:{uName:$("#username").val(), password:$("#password").val()},
		success: function(result){
			if(result != null){
//				window.location.href="main.html"
			}else{
				alert("用户名或密码错误");
			}
		}
	});
}
function cambiar_login() {
	
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.getElementById('erweima').style.display = "none";   
document.getElementById('a1').style.display = "block";   
  
setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }



function cambiar_login2() {
	 document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login2').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.getElementById('erweima').style.display = "block";   

document.getElementById('a1').style.display = "none";   
  
setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  



}

 




function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
  document.querySelector('.cont_form_login2').style.display = "none";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }

function ocultar_login_sign_up2() {
alert(2);
document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login2').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.getElementById('erweima').style.display = "block";   

document.getElementById('a1').style.display = "none";   
  
setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  
  }

 