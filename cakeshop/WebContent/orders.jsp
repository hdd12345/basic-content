<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/mycss/orders.css" />
        <script src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
		<script src="layer/layer.js" type="text/javascript"></script>
		<script src="js/myjs/orders.js" type="text/javascript"></script>
        <title>我的订单</title>
        <%		if(session.getAttribute("user")==null){
			response.sendRedirect("index.jsp");
		}%>
    </head>
    <body>
    	
    	
    	<div><button onclick="turn()">返回首页</button></div>
    	
    	<div id="orders-box">
    	
    	<div >
    		<div class="max-spl"></div>
    		<div class="dede">
    			<p>订单号：</p>
    			<p>时间：</p>
    			<p>总价：</p>
    		</div>
    		
    		<div class="ordersitem">
  				<div class="hhhhh">
  					<p>商品名称：</p>
  					<p>购买数量：</p>
  					<p>价格：</p>
  				</div>
    			<div class="hhhhh">
					<img class="iii" src="images/2.png" />
    			</div>
    		</div>
    		
    	</div>
    	
    	</div>
    	<input id="user_id" type="hidden" value="${user.user_id }">
 	</body>
</html>