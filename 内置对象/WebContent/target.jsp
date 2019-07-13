<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%--=//request.getParameter("name") --%>
	<%=pageContext.getRequest().getParameter("name") %>
</body>
</html>