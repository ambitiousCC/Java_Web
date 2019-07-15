<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL表达式也太好用了吧。。。 -->
用户名：${username }<br>
密码：${password }
<br>
<!-- forEach标签：遍历元素 -->
100~200中既能被5整除又能被4整除的数有
<c:forEach items="${arr}" var="arr" >
<c:if test="${arr%5==0&&arr%4==0}">
<c:out value="${arr }"></c:out>
</c:if>
</c:forEach>
</body>
</html>