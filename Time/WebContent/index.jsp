<!DOCTYPE html>
<html>
<head>   
       <meta charset="UTF-8">
       <!--include ECharts document-->
       <script src="js/common/echarts-3.0.js"></script>
      
       <title>
       ECharts de Hello World
       </title>
</head>
<body>
       <!--prepare a DOM with size for ECharts-->
       <div id="main" style="width: 600px;height: 400px;"></div>
       <div id="main2" style="width: 600px;height: 400px;"></div>
    <script type="text/javascript">
    //基于准备好的dom，初始化echarts实例
    var myChart=echarts.init(document.getElementById('main'));
    //指定图表的配置项和数据
    var option = {
    	    tooltip : {
    	        trigger: 'axis',
    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    	        }
    	    },
    	    legend: {
    	        data:['直接访问']
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
    	            data : ['周一','周二','周三','周四','周五','周六','周日']
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'直接访问',
    	            type:'bar',
    	            stack: '总量',
    	            itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
    	            data:[320, 302, 301, 334, 390, 330, 320]
    	        },
    	    ]
    	};
    	                    
      //使用刚指定的配置项和数据显示图表
      myChart.setOption(option);
    </script>
   
</body>
</html>