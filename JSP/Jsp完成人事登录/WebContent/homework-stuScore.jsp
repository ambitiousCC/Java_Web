<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "homework.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>学生成绩打印表</title>
</head>
<body>
<%!
	Map<String,Student> map = new HashMap<String,Student>();
	int i = 1;
%>
<%
	map.put("11071010",new Student("11071010","赵明","78"));
	map.put("11071011",new Student("11071011","李雷","100"));
	map.put("11071012",new Student("11071012","韩梅","90"));
	map.put("11071013",new Student("11071013","大熊","80"));
	map.put("11071014",new Student("11071014","李镜","92"));
	map.put("11071015",new Student("11071015","瘦虎","42"));
%>
<%
	for(String key : map.keySet()) {
		Student std = map.get(key);
%>
	<%--运用到了对象参数化，重写方法toString --%>
	<span>第<%=i %>条：<%=std.toString() %></span>
	<br>
<%
		i++;
	}
%>
</body>
</html>