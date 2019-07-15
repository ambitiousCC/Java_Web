<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() 
					+	request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath%>/elServlet">
	<p>用户名<input type="text" name="username" /></p>
	<p>密码<input type="password" name="password" /></p>
	<p><input type="submit" value="提交" /></p>
</form>
</body>
</html>