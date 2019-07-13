<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
 	<%	pageContext.setAttribute("age",12); %>
<%--
	pageContext内置对象的作用：
		forward方法完成请求转发
		include方法实现动态指令，通常运用到同一的导航栏等固定工作栏
		pageContext可以获取其他的内置对象：getRequest..
		
	pageContext可以设置属性，在当前页面(pageContext的作用域）都可以获取到设置的属性
 --%>
	<%--向另一个页面发送name属性值 、仍然停留在index页面，但是获取到了值--%>
	<%-- pageContext.forward("target.jsp?name=cuiqin"); --%>
	<%--如果想调用公用的页面，使用include --%>
	<%--pageContext.include("public.jsp"); --%>
	
<%--
	page对象：可以获得页面的基本信息
 --%>
 	page的基本信息：<%=this.getServletInfo() %>
 	<br>
 	pageContext作用域中获取的值：<%=pageContext.getAttribute("age") %>
</body>
</html>