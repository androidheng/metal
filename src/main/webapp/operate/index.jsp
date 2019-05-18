<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/admin.css">
    <link rel="icon" href="/favicon.ico">
    <style type="text/css">
        .sysName{
          
        }
    </style>
    <title>管理后台</title>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
                    
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a >
                        <a id="admin"></a>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>updatePassword.jsp">修改密码</a></dd>
                        <dd><a href="<%=basePath%>login.jsp">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    <!-- <img src="<%=basePath%>assets/images/logo.png" alt=""/> -->
                    <h1 style="font-size:16px;">生产数据智能分析系统</h1>
                </div>
                <ul id="Nav" class="layui-nav layui-nav-tree">
                    <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon ">&#xe770;</i>
                                <em>数据管理</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>operate/baseData.jsp">基本数据</a></dd>
                                <dd><a href="<%=basePath%>operate/carryData.jsp">运载数据</a></dd>
                                <dd><a href="<%=basePath%>operate/oreBlending.jsp">配矿数据</a></dd>
                                <dd><a href="<%=basePath%>operate/wareHouse.jsp">仓库数据</a></dd>
                                <dd><a href="<%=basePath%>operate/AnnualPlanData.jsp">年度计划数据</a></dd>
                            </dl>
                    </li>  
                    <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon layui-icon-form">&#xe63c;</i>
                                <em>数据统计</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>operate/historyData.jsp">历史数据查询</a></dd>
                               
                               
                            </dl>
                    </li>  
                    <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon layui-icon-table">&#xe62d;</i>
                                <em>报表</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>operate/carryTable.jsp">运载统计表</a></dd>
                                <dd><a href="<%=basePath%>operate/oreBlendingTable.jsp">配矿统计报表</a></dd>
                                <dd><a href="<%=basePath%>operate/wareHouseTable.jsp">仓库统计报表</a></dd>
                            </dl>
                    </li>  
                    <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon ">&#xe653;</i>
                                <em>总体指标对比</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>operate/everyMonth.jsp">每月与实际数据对比</a></dd>
                                <dd><a href="<%=basePath%>operate/everyMonthFinished.jsp">每月完成率</a></dd>
                            </dl>
                    </li>  
                  </ul>
           </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>
        </div>
        <table id="demo" lay-filter="demo" ></table>
        <div class="layui-footer">
            <p>© 2018 DEMO</p>
        </div>

        <div class="mobile-mask"></div>
    </div>
    <script src="<%=basePath%>assets/layui.js"></script>
    <script src="<%=basePath%>js/index.js" data-main="home"></script>
   <script>
    layui.use('table', function(){
   	 var table = layui.table,$=layui.$;
    	getUserInfo()
   	 //获取数据下拉框
     function getUserInfo(){
    	 $.ajax({
             url:"<%=basePath%>user/myInfo",
             type:'post',//method请求方式，get或者post
             dataType:'json',//预期服务器返回的数据类型
             contentType: "application/json; charset=utf-8",
             success:function(res){//res为相应体,function为回调函数
            	console.log(res)
            	$("#admin").html(res.data.username)
             },
             error:function(){
              
             }
         });
     }
     
   });
        
    </script>
</body>
</html>