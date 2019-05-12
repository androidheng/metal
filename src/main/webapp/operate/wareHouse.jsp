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
                  <a>仓库数据</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                       <div class="layui-inline">
                                                                              目的地
                          <div class="layui-inline">
                             <form class="layui-form" action="">
                               <select  id="wid" lay-verify="required"></select>
                             </form>
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
          ,url:'<%=basePath%>data/search2'
          ,cols: [[ //标题栏
        	   {field: 'carno', title: '车辆编号' }
              ,{field: 'tonnage', title: '运载吨数'}
              ,{field: 'minename', title: '出发地'}
              ,{field: 'warename', title: '目的地'}
              ,{field: 'nums', title: '车辆总趟数'}
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
    	          var wid = $('#wid');
    	        // var usertype = $('#usertype');
    	         //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             wid: wid.val(),
    	           }
    	         });
    	       }
    	     };
    	     
       $('.demoTable .layui-btn').on('click', function(){
    	    var type = $(this).data('type');
    	    active[type] ? active[type].call(this) : '';
    	});
      
       getWid()
       function renderForm(){
    	    layui.use('form', function(){
    	        var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
    	        form.render();
    	    });
       }
       
     
      
      //获取仓库名称
       function getWid(){
    	   $.ajax({
               url:"<%=basePath%>warehouse/findAll",
               type:'post',//method请求方式，get或者post
               dataType:'json',//预期服务器返回的数据类型
               contentType: "application/json; charset=utf-8",
               success:function(res){//res为相应体,function为回调函数
              	   let options = "<option value=''></option>"
                   res.forEach(item=>{
                  	 options+="<option value='" + item.id + "'>" + item.warename + "</option>";
                   })
                  $("#wid").html(options)
                 
                  renderForm()
               },
               error:function(){
                
               }
           });
       }
     
      
     
});
   </script>
</body>
</html>