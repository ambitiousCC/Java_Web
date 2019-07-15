<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//转向：调用test1.jsp会自动转向到test2.jsp其中并调用了过滤器
	//request.getRequestDispatcher("/test2.jsp").forward(request, response);//测试dispatcher FORWARD配置
	//response.sendError(404);//试dispatcher ERROR配置
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test1</title>
</head>
<body>
	<!-- 测试dispatcher INCLUDE配置  -->
	<jsp:include page="test2.jsp"></jsp:include>
	<h1>Test1</h1>
</body>
</html>