<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
//登录完成，将登录用户名存储至session对象
session.setAttribute("loginUser", username);

response.sendRedirect(request.getContextPath()+"/main.jsp");
%>
