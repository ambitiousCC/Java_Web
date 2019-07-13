<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "DB.*" %>
<%@ page import = "loginBean.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	Map<String,emp> map = DBUtil.map;
	emp emp = map.get(request.getParameter("account"));
	emp.setEmail(request.getParameter("email"));
	emp.setName(request.getParameter("name"));
%>
<h3 align="center">修改信息成功</h3>
</body>
</html>