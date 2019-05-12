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
                  <a>每月与实际数据对比</a>
                </span>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                        <div class="layui-inline">
                                                                         矿山名称                                               
                         <div class="layui-inline">
                          <form class="layui-form" action="">
                             <select  id="mid" lay-verify="required"></select>
                          </form>
                         
                         </div>
                                                                            时间
                         <div class="layui-inline" >
                            <input type="text" id="date" class="layui-input">  
                         </div>
                        </div>
                      <button class="layui-btn" id="search">查询</button>
                    </div>
                    
                     <div id="main" style="width: 100%;height:600px;"></div>
                    
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.all.js"></script>
    <script src="<%=basePath%>assets/echarts.min.js"></script>
  
   
    <script>
    var myChart = echarts.init(document.getElementById('main'));   

    var 
    option = {
    	    tooltip : {
    	        trigger: 'axis',
    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    	        }
    	    },
    	    legend: {
    	        data:['计划数据','实际数据']
    	    },
    	    grid: {
    	        left: '3%',
    	        right: '4%',
    	        bottom: '3%',
    	        containLabel: true
    	    },
    	    xAxis : [
    	        {
    	            type : 'category',
    	            data : ['土方量','货物产量','挖机耗油量','卡车耗油量','设备维修费用','每土方工资']
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'计划数据',
    	            type:'bar',
    	            data:[320, 332, 301, 334, 390, 330, 320]
    	        },
    	        {
    	            name:'实际数据',
    	            type:'bar',
    	            data:[120, 132, 101, 134, 90, 230, 210]
    	        },
    	    ]
    	};

   
   // ;
   
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	 //重新渲染表单
    	 getDataType()
    	
         function renderForm(){
          layui.use('form', function(){
          var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
          form.render();
          });
         }
    	 layui.use('laydate', function(){
	     	  var laydate = layui.laydate;
	          //执行一个laydate实例
	     	  laydate.render({
	     	    elem: '#date', //指定元素
	     	    type:'month',
	     	    value: '2019-05-12'
	     	  });
         });
    	 
    	 //获取数据下拉框
         function getDataType(){
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
        	 getdata()
         });
        function getdata(){
        	 let date = $("#date").val()
        	 let mid = $("#mid").val()
        	 $.ajax({
                 url:" <%=basePath%>yearplan/findData?date="+date+"&mid="+mid,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	option.series[0].data = res.data1;
                 	option.series[1].data = res.data2;
                 	myChart.setOption(option)
                 },
                 error:function(){
                  
                 }
             });
         }
       
});
   </script>
</body>
</html>