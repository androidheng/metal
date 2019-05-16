<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
	<body>
		<div class="input-group-btn" style="text-align: center;">
			<button type="button" onclick="doHistorydata();">导出历史数据</button><br><br>
			<button type="button" onclick="doYundata();">导出运载数据</button><br><br>
			<button type="button" onclick="doYundata2();">导出报表数据</button><br><br>
		</div>
		<script type="text/javascript">
		function doHistorydata(){
			location.href='<%=basePath%>base/exporthistory?mid=1&date=2019-05';
		}
		function doYundata(){
			location.href='<%=basePath%>data/exportYun?type=0&date=2019-05-11';
		}
		function doYundata2(){
			location.href='<%=basePath%>data/exportstatistical?type=0&date=2019-05-11';
		}
		</script>
	</body>
</html>