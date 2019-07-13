<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事信息修改</title>
</head>
<body>
	<h3 align="right">登录账号：<%=session.getAttribute("a") %></h3>
	<h3 align="center">修改方案</h3>
	<hr>
	<form action="updata_control.jsp"><!-- 传递封装好的数据 -->
		<table align="center" width="500px" border="1px">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="account" value="<%=request.getParameter("account")%>"/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="<%=request.getParameter("email")%>"/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="<%=request.getParameter("name")%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>