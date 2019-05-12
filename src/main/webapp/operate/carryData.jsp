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
     <div class="layui-content" id="box" style="display:none">
        <form class="layui-form" action="" lay-filter="formTest">
           <div class="layui-form-item">
               <label class="layui-form-label">日期</label>
               <div class="layui-input-block">
                  <input  type="text" id="createDate" name="createtime"  class="layui-input spacil"> 
               </div>
           </div>
           <div class="layui-form-item">
              <label class="layui-form-label">矿山名</label>
                <div class="layui-input-block">
                   <select id="addMid" name="mid" lay-verify="required"></select>
               </div>
           </div>
           <div class="layui-form-item">
              <label class="layui-form-label">仓库名</label>
                <div class="layui-input-block">
                   <select id="addWid" name="wid" lay-verify="required"></select>
               </div>
           </div>
           <div class="layui-form-item">
               <label class="layui-form-label">车辆编号</label>
               <div class="layui-input-block">
                 <input type="text" name="carno" required  lay-verify="required" class="layui-input">
               </div>
           </div>
           <div class="layui-form-item">
               <label class="layui-form-label">运载吨数</label>
               <div class="layui-input-block">
                 <input type="number" name="tonnage"  required  lay-verify="required" class="layui-input spacil">吨
               </div>
           </div>
           <div class="layui-form-item">
            <div class="layui-input-block">
               <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
               <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
          </div>
        </form>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>运载数据</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                       <div class="layui-inline">
                                                                              出发地
                          <div class="layui-inline">
                             <form class="layui-form" action="">
                               <select  id="mid" lay-verify="required"></select>
                             </form>
                          </div>
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
    <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加运载数据</button>
     </div>
    </script>
    
   

    <script>
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	//展示已知数据
        table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'

          ,url:'<%=basePath%>data/search'
          ,cols: [[ //标题栏
             {field: 'carno', title: '车辆编号' }
            ,{field: 'tonnage', title: '运载吨数'}
            ,{field: 'minename', title: '出发地'}
            ,{field: 'warename', title: '目的地'}
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
    	         var mid = $('#mid');
    	         var wid = $('#wid');
    	        // var usertype = $('#usertype');
    	         //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             mid: mid.val(),
    	             wid: wid.val(),
    	           }
    	         });
    	       }
    	     };
    	     
       $('.demoTable .layui-btn').on('click', function(){
    	    var type = $(this).data('type');
    	    active[type] ? active[type].call(this) : '';
    	});
       getMine()
       getWid()
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
                  $("#addMid").html(options)
                  renderForm()
               },
               error:function(){
                
               }
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
                  $("#addWid").html(options)
                  renderForm()
               },
               error:function(){
                
               }
           });
       }
       //头工具栏事件
       table.on('toolbar(demo)', function(obj){
    	  switch(obj.event){
    	  case 'add':
    	        add()
    	       break;
    	         
    	  };
       });
       function add(data){
    	   layer.open({
    	         type: 1
    	        ,title: false //不显示标题栏
    	        ,closeBtn: true
    	        ,area: ['800px','600px']
    	        ,shade: 0.8
    	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
    	        ,btnAlign: 'c'
    	        ,moveType: 1 //拖拽模式，0或者1
    	        ,content: $("#box"),
    	         success:function(layero, index){
                      layui.use('laydate', function(){
    	             	  var laydate = layui.laydate;
    	             	   //执行一个laydate实例
    	             	  laydate.render({
    	             	    elem: '#createDate' //指定元素
    	             	  });
    	               });
                      //监听提交
                      form.on('submit(demo1)', function(data){
                    	  $.ajax({
                              url:"<%=basePath%>data/addOrUpdate",
                              type:'post',//method请求方式，get或者post
                              dataType:'json',//预期服务器返回的数据类型
                              data:JSON.stringify(data.field),
                              contentType: "application/json; charset=utf-8",
                              success:function(res){//res为相应体,function为回调函数
                            	  layer.close(index)
                                  $(".layui-laypage-btn")[0].click();
                              },
                              error:function(){
                               
                              }
                          });
                      
                        return false;
                      });
    	        	
  	    	}
      	 
    	        
    	       ,end:function(index){
    	        	layer.close(index)
    	        }
    	      })
       }
     
     
});
   </script>
</body>
</html>