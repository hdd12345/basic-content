function sortDuration() {
	$.ajax({
		url : "http://localhost:8080/Time/user/sort",
		type : "post",
		xhrFields : {
			withCredentials : true
		},
		crossDomain : true,
		dataType : "json",
		success : function(result) {
			var div = document.getElementById("left");
			var array = new Array();
			array = result;
			var list = "<div id='myTabContent' class='tab-content'>" +
					"<div role='tabpanel' class='tab-pane fade in active' id='home'" +
					"aria-labelledby='home-tab'><div id='container'><ul id='sort' class='list'>";
			for (var i = 1; i <= array.length; i++) {
				list += "<a href='javascript:;'><li>"
						+ "<section class='list-left'>" + "<h5 class='title'>"
						+ "用户名："+array[i - 1].uName + "</h5>"
						+ "<span class='adprice'>" + "时长(min):"+array[i - 1].duration
						+ "</span>" 
						+ "</section><section class='list-right'>"
						+ "<span class='date'>" + "排名:"+i
						+ "</span>"
						+ "</section><div class='clearfix'></div></li></a>";
			}
			list += "</ul></div></div></div>"
			div.innerHTML = list;
			
		}
		
	});
}

function sortMap(){
	//清空上一次的图表
	echarts.dispose(document.getElementById("left"));
	//基于准备好的dom，初始化echarts实例
	var myChart=echarts.init(document.getElementById('left'));

    //异步加载数据
      $.post('http://localhost:8080/Time/user/sort').done(function (data) {
    	  var array = new Array();
    	  array = data;
    	  var ehdata = "{'uName':[";
//    	  for(var i=0;i<array.length;i++){
//    		  if(i == array.length-1){
//    			  ehdata += "'" + array[i].uName + "'],'duration':[";
//    		  }else{
//    			  ehdata += "'" + array[i].uName + "',";
//    		  }
//    	  }
//    	  for(var i=0;i<array.length;i++){
//    		  if(i == array.length-1){
//    			  ehdata += "'" + array[i].duration + "']}";
//    		  }else{
//    			  ehdata += "'" + array[i].duration + "',";
//    		  }
//    	  }
    	  //按json数组的格式重新整合数据字符串，降序
    	  for(var i = array.length-1; i>=0; i--){
    		  if(i == 0){
    			  ehdata += "'" + array[i].uName + "'],'duration':[";
    		  }else{
    			  ehdata += "'" + array[i].uName + "',";
    		  }
    	  }
    	  for(var i = array.length-1; i >= 0; i--){
    		  if(i == 0){
    			  ehdata += "'" + array[i].duration + "']}";
    		  }else{
    			  ehdata += "'" + array[i].duration + "',";
    		  }
    	  }
    	  
//    	  ehdata = "{'uName':['Android','IOS','PC','Other'],'duration':[420,200,360,100]}";
          data = eval('('+ehdata+')'); 
          
        //指定图表的配置项和数据，使用指定的div和数据显示图表
          myChart.setOption({
    	    tooltip : {
    	        trigger: 'axis',
    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    	        }
    	    },
    	    legend: {
    	        data:['全部']
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'category',
    	            data : data.uName
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'时长(h)',
    	            type:'bar',
    	            stack: '总量',
    	            itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
    	            data: data.duration
    	        },
    	    ]
    	})
      })
}

$(document).ready(function(){
	
	var x;
	var flag;
	//start按钮监听
	$("#start").on("click",function(){
		flag = true;
		$("#start").hide();
		$("#select-box").hide();
		$("#stop").show();
		$("#vis-box").show();
		var uId= $("#userId").val();//当前用户id
		var start = new Date();
		//intDiff为总秒数
		var intDiff = parseInt($("#select-hour option:selected").val()*60*60)+
				parseInt($("#select-minute option:selected").val()*60)+
				parseInt($("#select-second option:selected").val());
		//预计获得积分
		var integral = intDiff/600;
		$("#a").html(integral);
		x = window.setInterval(function() {
		var hour = 0;
		var minute = 0;
		var second = 0;
		intDiff--;
		if(intDiff>0){
			hour = Math.floor(intDiff/(60*60));
			minute = Math.floor(intDiff/(60))-hour*60;
			second = intDiff-hour*60*60-minute*60;	
		}
		if(hour<=9){hour='0'+hour};
		if(minute<=9){minute='0'+minute};
		if(second<=9){second='0'+second};
		$("#hour").html(hour);
		$("#minute").html(minute);
		$("#second").html(second);
		if(intDiff==0){
			clearInterval(x);
			flag = false;
			layer.msg("计时完成！您已获得积分！");
			$("#stop").hide();
			$("#vis-box").hide();
			$("#start").show();
			$("#vis-box").show();
			//此处填写ajax与后台交互，即添加积分
			
			var stop = new Date();
				
			$.ajax({
				url : "http://localhost:8080/Time/timeLog/addTimeLog",
				type : "post",
				xhrFields : {
					withCredentials : true
				},
				crossDomain : true,
				contentType : "application/json",
				dataType : "json",
				data :JSON.stringify({
					"uId": uId,
					'start':start,
					'expire':stop,
					'failtime':stop,
					'achieve':integral
				}),
				success : function() {
				}
			});
			
		}
		
	},1000);
		//stop按钮监听
		$("#stop").on("click",function(){
			var failTime = new Date();
			if(flag){
				//弹出对话框，10秒内若不点取消按钮中断倒计时
				var y=setTimeout(function(){
					clearInterval(x);
					},10000);
				layer.confirm("确定要放弃吗？",function(index){
					layer.close(index);
					clearInterval(x);
					$("#stop").hide();
					$("#vis-box").hide();
					$("#start").show();
					$("#select-box").show();
					flag = false;
				},function(index){
					layer.close(index);
					clearTimeout(y);
				});
				$.ajax({
					url : "http://localhost:8080/Time/timeLog/addTimeLog",
					type : "post",
					xhrFields : {
						withCredentials : true
					},
					crossDomain : true,
					contentType : "application/json",
					dataType : "json",
					data :JSON.stringify({
						"uId": uId,
						'start':start,
						'expire':stop,
						'failtime':failTime,
						'achieve':0
					}),
					success : function() {
					}
				});
			}
		});
		//鼠标移出窗口监听
		$(document).mouseleave(function(){
			var failTime = new Date();
			if(flag){
				layer.alert("计时已中断！");
				clearInterval(x);
				$("#stop").hide();
				$("#vis-box").hide();
				$("#start").show();
				$("#select-box").show();
				flag = false;
				$.ajax({
					url : "http://localhost:8080/Time/timeLog/addTimeLog",
					type : "post",
					xhrFields : {
						withCredentials : true
					},
					crossDomain : true,
					contentType : "application/json",
					dataType : "json",
					data :JSON.stringify({
						"uId": uId,
						'start':start,
						'expire':stop,
						'failtime':failTime,
						'achieve':0
					}),
					success : function() {
					}
				});
			}	
		});
	});
	//stop按钮监听
//	$("#stop").on("click",function(){
//		var failTime = new Date();
//		if(flag){
//			//弹出对话框，10秒内若不点取消按钮中断倒计时
//			var y=setTimeout(function(){
//				clearInterval(x);
//				},10000);
//			layer.confirm("确定要放弃吗？",function(index){
//				layer.close(index);
//				clearInterval(x);
//				$("#stop").hide();
//				$("#vis-box").hide();
//				$("#start").show();
//				$("#select-box").show();
//				flag = false;
//			},function(index){
//				layer.close(index);
//				clearTimeout(y);
//			});
//			
//			$.ajax({
//				url : "http://127.0.0.1/Time/timeLog/addTimeLog",
//				type : "post",
//				dataType:"json",
//				data :JSON.stringify({
//					'start': start,
//					'failtime': failTime,
//					'expire' : stop,
//				}),
//				success : function(result){
//					
//				}
//			
//			})
//		}
//	});
	//鼠标移出窗口监听
//	$(document).mouseleave(function(){
//		var failTime = new Date();
//		if(flag){
//			layer.alert("计时已中断！");
//			clearInterval(x);
//			$("#stop").hide();
//			$("#vis-box").hide();
//			$("#start").show();
//			$("#select-box").show();
//			flag = false;
//			$.ajax({
//				url : "http://127.0.0.1/Time/timeLog/addTimeLog",
//				type : "post",
//				dataType:"json",
//				data :JSON.stringify({
//					'start': start,
//					'failtime': failTime,
//					'expire' : stop,
//				}),
//				success : function(result){
//					
//				}		
//				})
//		}	
//	});
});
//if("确定要终止吗？"){
//clearInterval(x);
//$("#stop").hide();
//$("#vis-box").hide();
//$("#start").show();
//$("#select-box").show();
//flag = false;
//}
