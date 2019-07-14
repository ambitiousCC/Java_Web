<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	//路径到底是怎么回事
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() 
			+ request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath %>/calServlet" method="post">
<p>加法计算器</p>
<p>加数1：<input type="text" name="n1" /></p>
<p>加数2：<input type="text" name="n2" /></p>
<br>
<input type="submit" value="计算" />
</form>
</body>
</html>