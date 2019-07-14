<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String str = "崔秦";
	String get() {
		return str;
	}
%>
<hr>
<%
	out.println(str);
%>
<hr>
<%=
	this.get()
%>
</body>
</html>