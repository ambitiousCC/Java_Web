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
	//String re = (String)request.getAttribute("a");
	//out.println(re);
	
	String ag = (String)application.getAttribute("b");
	out.println(ag);
%>
</body>
</html>