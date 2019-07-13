<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		使用errorPage需要声明，并且重新设置默认值
		exception对象只能在错误页面中使用
		可以指定专门页面处理错误
	 --%>
	<%=exception.getMessage() %>
</body>
</html>