<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.if {
	text-align:center;
}
</style>
</head>
<body>
<%! int i = 10; %>
<%--输出表达式中不需要分号 
	可以返回带有返回值的方法
--%>
i的值是<%= i %>
<hr>
i的值是<% out.println(i); %>
<%--可以看到第一中更加方便处理网页信息 --%>
<hr>
<%! int x = 10;
	int y = 0;
%>
<%if(x<0) {%>
<div class="if"><span>当x<0时,输出</span></div>
<div class="if">x=<%=x %></div>
<div class="if">y=<%=y %></div>
<%	}
	else if(x==0) {%>
<div class="if"><span>当x=0时,输出</span></div>
<div class="if">x=<%=x %></div>
<div class="if">y=<%=y %></div>
<%
	}
	else if(x>0) { %>
<div class="if"><span>当x>0时,输出</span></div>
<div class="if">x=<%=x %></div>
<div class="if">y=<%=y %></div>
<%}%>
</body>
</html>