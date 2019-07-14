<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!//在jsp文件中代码可以出现多次，只要保持上下逻辑的一致性
	int i = 10;
%>
<%
	if(i>10) {
		out.println("i>10");
	} else {
		out.println("i<=10");
	}
%>
<hr>
<%//代码与页面标签交叉，可以在页面开发中更加有效
   if(i>10) {%>
<span>i>10</span>
<%}else{ %>
<span>i<=10</span>
<%} %>
</body>
</html>