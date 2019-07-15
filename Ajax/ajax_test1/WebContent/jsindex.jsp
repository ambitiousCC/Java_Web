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
</head>
<body style="text-align:center;">
	<input type="button" flag="1" value="职员" class="btn" onclick="showA()"/>
	<input type="button" flag="2" value="职位" class="btn" onclick="showB()" />
	<input type="button" flag="3" value="流行歌曲" class="btn" onclick="showC()" />
	<br>
	<div id="con">
	<h1 class="content1"></h1>
	<h1 class="content2"></h1>
	<h1 class="content3"></h1>
	</div>
	<div id="div1"></div>
</body>
<script type="text/javascript">
	function showA() {
		//创建一个请求对象
		var xmlhttp = new XMLHttpRequest();
		//确定请求类型，url以及是否异步
		xmlhttp.open("GET","<%=basePath%>/servlet?flag=1",true);
		//请求发送到服务器
		xmlhttp.send();
		//接受服务器的响应(readyState==4表示请求已经完成并且响应已经就绪 status==200表示请求响应一切正常)
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200) {
														//服务器给ajax的数据
				document.getElementById("div1").innerHTML=xmlhttp.responseText;
			}
		}
	}
	function showB() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET","<%=basePath%>/servlet?flag=2",true);
		xmlhttp.send();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200) {
				document.getElementById("div1").innerHTML=xmlhttp.responseText;
			}
		}
	}
	function showC() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET","<%=basePath%>/servlet?flag=3",true);
		xmlhttp.send();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200) {
				document.getElementById("div1").innerHTML=xmlhttp.responseText;
			}
		}
	}
</script>
</html>