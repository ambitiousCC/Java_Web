<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>求1-100数字和</title>
</head>
<body>
<%! //这种是定义成员变量和成员方法的标签
	int totalCount = 0;
	int sum = 0;
%>
<%
	int localCount = 0;
	totalCount++;
	localCount++;
%>
<%
	out.println("局部变量"+localCount);//局部变量，每一次都会刷新
	out.println("<br>");
	out.println("成员变量"+totalCount);//保持递增
%>
<hr>
<%
	for(int i=1; i<=100; i++) {
		sum += i;
	}
%>
<%	out.println("1-100的和是："+sum); %>
</body>
</html>