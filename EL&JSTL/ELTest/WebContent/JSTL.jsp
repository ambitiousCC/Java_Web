<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<form action="<%=basePath %>/JSTLEL" ><input type="text" name="df" /><input type="submit" value="提交" /></form>
<!-- set:存储变量 -->
<c:set var="username" value="cc" scope="request"></c:set>
<c:set var="age" value="12" scope="request"></c:set>
<hr>
<!-- out:输出打印 -->
<c:out value="${username }">></c:out>
<hr>
<!-- remove:删除属性 -->
<c:remove var="username" scope="request" ></c:remove>
<c:out value="${username }"></c:out>
<!-- if标签：选择判断 -->
<c:if test="${age>12 }">
你大于12岁
</c:if>
<!-- choose标签：仿if-else语句 -->
<c:choose>
	<c:when test="${age<12 }">您小于12</c:when>
	<c:otherwise>您12岁</c:otherwise>
</c:choose>
<hr>
</body>
</html>