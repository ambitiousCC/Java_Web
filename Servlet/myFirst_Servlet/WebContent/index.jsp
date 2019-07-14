<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 下面是实现动态链接，解决更改服务器、ip地址等情况 -->
<%
					//http协议						服务器名							服务器端号						
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + 
					request.getServletContext().getContextPath();
					//存放路径
	//原链接:http://localhost:8080//myFirst_Servlet/loginServlet
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>								<!-- 添加虚拟路径 -->
		<form action="<%=basePath %>/loginServlet" method="post">
			<p>账号<input type="text" name="account" />
			<p>密码<input type="password" name="password" />
			<p><input type="submit" value="提交"  /></p>
		</form>
</body>
</html>