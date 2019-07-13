<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%-- 导入包的格式 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	public String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd hh:mm");
		Date currentTime = new Date();//格式化函数
		return formatter.format(currentTime);
}
%>
<%=getNow() %>
<hr>
<%!
	List contents = new ArrayList();
%>
<%
	contents.add("第1条：JSP基础入门");
	contents.add("第2条：Servlet视频详解");
	contents.add("第3条：EL表达式初始");
	contents.add("第4条：JSTL标签库初始");
%>
<%	for(int i = 0; i < contents.size();i++) {%>
<div><%=contents.get(i) %></div>
<br>
<%}%>
</body>
</html>