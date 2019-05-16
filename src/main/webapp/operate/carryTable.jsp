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
      .spacil {
    display: inline-block;
    margin-right:2px;
    width: 90%;
   
}
    </style>
    <title>管理后台</title>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>运载数据报表</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                       <div class="layui-inline">
                                                                              报表类型
                         <div class="layui-inline">
                          <form class="layui-form" action="">
                           <select  id="type" lay-verify="required"  lay-filter="business">
                              <option value="0">日报表</option>
                              <option value="1">月报表</option>
                              <option value="2">年报表</option>
                           </select>
                          </form>
                        </div>
                                                                            时间
                         <div class="layui-inline" >
                            <input type="text" id="date" class="layui-input">  
                         </div>
                          <div class="layui-inline" >
                            <input type="text" id="month" class="layui-input" style="display:none;">  
                         </div>
                          <div class="layui-inline" >
                            <input type="text" id="year" class="layui-input" style="display:none;">  
                         </div>
                        </div>
                      <button class="layui-btn" data-type="reload">查询</button>
                    </div>
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.all.js"></script>
    <script>
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	 
    	//展示已知数据
        table.render({
           elem: '#demo'
          ,url:'<%=basePath%>data/findYun'
          ,cols: [[ //标题栏
        	
             {field: 'carno', title: '车牌号' }
            ,{field: 'minename', title: '矿山名'}
            ,{field: 'nums', title: '运载次数'}
            ,{field: 'nums', title: '车辆总趟数'}
            ,{field: 'tonnage', title: '运载总吨数'}
            ,{field: 'warename', title: '仓库名'}
            ,{field: 'createtime', title: '创建时间'}
           
         ]]
         
        ,id:'testReload'
        ,skin: 'line' //表格风格
        ,even: true
        ,page: true //是否显示分页
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
       });
       var  active = {
    	       reload: function(){
    	         var type = $('#type');
    	         var date = $('#date');
    	         var month = $('#month');
    	         var year = $('#year');
    	        // var usertype = $('#usertype');
    	         //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             type: type.val(),
    	             date: type.val()==0?date.val():type.val()==1? month.val():year.val(),
    	           }
    	         });
    	       }
    	     };
    	     
       $('.demoTable .layui-btn').on('click', function(){
    	    var type = $(this).data('type');
    	    active[type] ? active[type].call(this) : '';
    	});
     
       form.on('select(business)', function(data){
    	   switch (data.value) {
    		   case '0':
    			   $("#date").show();
    			   $("#month").hide();
    			   $("#year").hide();
    			   break;
    		   case '1':
    			   $("#date").hide();
    			   $("#month").show();
    			   $("#year").hide();
    			   break;
    		   case '2':
    			   $("#date").hide();
    			   $("#month").hide();
    			   $("#year").show();
    			   break;
    			   
    	   }
    	 
    	 
       })
       layui.use('laydate', function(){
     	     	  var laydate = layui.laydate;
     	          //执行一个laydate实例
     	     	  laydate.render({
     	     	    elem: '#date', //指定元素
     	     	    value: '2019-05-12'
     	     	  });
       });
       layui.use('laydate', function(){
	     	  var laydate = layui.laydate;
	     	  //执行一个laydate实例
	     	  laydate.render({
	     	    elem: '#month', //指定元素
	     	    type:"month"
	     	  });
	     }); 
       layui.use('laydate', function(){
	     	  var laydate = layui.laydate;
	     	  
	     
	     	  //执行一个laydate实例
	     	  laydate.render({
	     	    elem: '#year', //指定元素
	     	    type:"year"
	     	  });
	     }); 
   });
   </script>
</body>
</html>