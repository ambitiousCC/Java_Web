<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<!--创建登录页面-->
<%--
	session对象：
		跟踪主要会话 可以共享信息
			会话是代表用户第一次进入当前系统知道退出系统或者关闭浏览器，在此期间与副武器的一系列操作
		可以设置生命周期：主要应用在过一段时间以后页面就不会保存密码
--%>
<h3 align="center">人事登录</h3>
<hr>
<form action="control.jsp">
	<table align="center">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="account"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="password"/></td>		
		</tr>
		<tr>
			<td>
				<input type="submit" value="提交"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>