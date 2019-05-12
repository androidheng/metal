<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
   
    <link rel="icon" href="/favicon.ico">
    <style>
      
    </style>
    <title>管理后台</title>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>历史数据</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                       矿山名称：
                      <div class="layui-inline">
                          <form class="layui-form" action="">
                             <select  id="mid" lay-verify="required"></select>
                          </form>
                      </div>
                                                                   日期：
                      <div class="layui-inline">
                         <input type="text" id="date" class="layui-input">  
                      </div>
                        
                      <button class="layui-btn" id="search">查询</button>
                      <button class="layui-btn" id="importExcel">导出Excel</button>
                    </div>
                    
                     <div id="line" style="width: 100%;height:600px;"></div>
                     <div id="bar" style="width: 100%;height:600px; margin-top:50px;"></div>
                    
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.all.js"></script>
    <script src="<%=basePath%>assets/echarts.min.js"></script>
  
   
    <script>
    var line = echarts.init(document.getElementById('line'));   
    var bar = echarts.init(document.getElementById('bar'));   

    var lineOption = {
    	    xAxis: {
    	        type: 'category',
    	        boundaryGap: false,
    	        data: []
    	    },
    	    yAxis: {
    	        type: 'value'
    	    },
    	    series: [{
    	        data: [],
    	        type: 'line',
    	        areaStyle: {}
    	    }]
    	};
    var barOption =  {
    	    xAxis: {
    	        type: 'category',
    	        data: ['2019-05-11','2019-05-11']
    	    },
    	    yAxis: {
    	        type: 'value'
    	    },
    	    series: [{
    	        data: [],
    	        type: 'bar'
    	    }]
    	};

   
    layui.use('laydate', function(){
    	  var laydate = layui.laydate;
    	  
    	  //执行一个laydate实例
    	  laydate.render({
    	    elem: '#date', //指定元素
    	    type:'month'
    	  });
    });
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	 //重新渲染表单
    	 getMine()
    	
         function renderForm(){
            layui.use('form', function(){
                var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
                form.render();
            });
         }
    	//获取矿山名称
         function getMine(){
      	   $.ajax({
                 url:"<%=basePath%>mine/findAll",
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	   let options = "<option value=''></option>"
                       res.forEach(item=>{
                    	 options+="<option value='" + item.id + "'>" + item.minename + "</option>";
                       })
                       $("#mid").html(options)
                       renderForm()
                 },
                 error:function(){
                  
                 }
             });
         }
    	
         //查询
         $(document).on('click','#search',function(){
        	 getLineData();
        	 getBarData()
         });
         $(document).on('click','#importExcel',function(){
        	 let mid = $("#mid").val()
        	 let date = $("#date").val()
             if(!mid) return alert('请先选择矿山');
        	 if(!date) return alert('请先选日期');
        	 location.href="<%=basePath%>base/exporthistory?mid="+mid+"&date="+date;
         });
         function getLineData(){
        	 let mid = $("#mid").val()
        	 let date = $("#date").val()
        	 $.ajax({
                 url:"<%=basePath%>base/findZheData?mid="+mid+"&date="+date,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	
                	lineOption.xAxis.data = res.data;
                	lineOption.series = res.series;
                 	
                 	line.setOption(lineOption)
                    console.log(res)
                 },
                 error:function(){
                  
                 }
             });
         }
         function getBarData(){
        	 let mid = $("#mid").val()
        	 let date = $("#date").val()
        	 $.ajax({
                 url:"<%=basePath%>base/findZhuData?mid="+mid+"&date="+date,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	 barOption.xAxis.data = res.xdata;
                	 barOption.series[0].data = res.data;
                	 console.log('barOption:',barOption)
                 	 bar.setOption(barOption)
                	 console.log(res)
                 },
                 error:function(){
                  
                 }
             });
         }
       
});
   </script>
</body>
</html>