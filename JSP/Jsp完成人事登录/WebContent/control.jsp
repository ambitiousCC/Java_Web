<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
    pageEncoding="UTF-8"%>
<%@ page import = "DB.*" %>
<%@ page import = "loginBean.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
	String account = request.getParameter("account");
	String password = request.getParameter("password");
%>
<%
		emp emp = new emp(account,password,null,null);
		boolean flag = DBUtil.selectEmpByAccountAndPassword(emp);
		Map<String,emp> map = DBUtil.map;
		
	/*
	*	利用application 属性：生命周期：web服务器存活长度
	*	可以用来设置访问量
	*/
		if(flag) {//登录成功，在此利用session记录账号信息
			//第一次登陆设置属性为空
			Object o = application.getAttribute("count");
			if(o==null) {
				application.setAttribute("count",1);
			} else {
				int count = Integer.parseInt(o.toString());
				application.setAttribute("count",count+1);//不能用count++，每次刷新页面count值就会恢复默认值，只能在原来基础上加1也就是count+1 
			}
			session.setAttribute("a", account);//后面是被记录的对象
		//设置有效周期为20s
		//session.setMaxInactiveInterval(20);
%>
		<h3 align="right">访问次数<%= application.getAttribute("count") %></h3>
		<h3 align="right">登录账号<%=session.getAttribute("a") %></h3>
		<h3 align="center">欢迎来到人事管理系统</h3>
		<hr>
		<table align="center" border="1px solid black" width="500px">
			<tr>
				<td>用户名</td>
				<td>邮箱</td>
				<td>姓名</td>
				<td>修改</td>
			</tr>
				<%
					for(String key : map.keySet()) {
						emp e = map.get(key);
				%>
			<tr>
					<td>
						<%=e.getAccount() %>
					</td>
					<td>
						<%=e.getEmail() %>
					</td>
					<td>
						<%=e.getName() %>
					</td>
					<td>
						<!-- 
							URL传递参数
							URL ? key=value & key=value...不需要双引号
							不要作死增加空格
						 -->
						<a href="updata.jsp?account=<%=e.getAccount()%>&email=<%=e.getEmail()%>&name=<%=e.getName()%>">修改</a>
					</td>
			</tr>
				<%
					}
				%>
		</table>
<%	
	} else {
		throw new Exception("账号和密码错误");
	}
%>
</body>
</html>