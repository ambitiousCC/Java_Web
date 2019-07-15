<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
</head>
<body style="text-align:center;">
	<input type="button" value="one" class="btn"/>
	<input type="button" value="two"  class="btn" />
	<input type="button" value="three"	class="btn" />
	<br>
	<div class="con">
	<h1 class="content1"></h1>
	<h1 class="content2"></h1>
	<h1 class="content3"></h1>
	</div>
</body>
<script type="text/javascript">
$(".btn").click(function(){
	var _name = $(this).val();
	//单击按钮触发
	$.ajax({
		url:"<%=basePath%>/servlet",
		type:"post",
		data:{
			name:_name
		},
		dataType:"json",
		success:function(result) {
			//响应代码
			var flag = result.flag;
			if("pop"==flag) {
				$(".content1").text("稻香");
				$(".content2").text("晴天");
				$(".content3").text("告白气球");
			} else if ("classes"==flag) {
				$(".content1").text("千千厥歌");
				$(".content2").text("傻女");
				$(".content3").text("七友");
			} else if ("rock"==flag) {
				$(".content1").text("一块红布");
				$(".content2").text("假行僧");
				$(".content3").text("新长征路上的摇滚");
			} else if ("null"==flag) {
				$(".content1").text("失败");
			}
		}
	});
});
</script>
</html>