<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object s = application.getAttribute("sum");
%>
<p>加法运算器：</p>
<p>运算结果为：<%--=request.getAttribute("sum") --%><%=s %></p>
</body>
</html>