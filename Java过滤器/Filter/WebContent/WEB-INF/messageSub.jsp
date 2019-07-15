<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.*" %>

<% 	
	//弄一个集合存储
	List<Message> messages = (List<Message>)session.getAttribute("messages");
	if(messages == null){
		//如果没有在session中没有message属性
		messages = new ArrayList<Message>();
		session.setAttribute("messages", messages);
	}
	
	//获得文案标题
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	//创建文案对象
	Message message = new Message();
	message.setTitle(title);
	message.setContent(content);
	//最后存储到session之中
	messages.add(message);//留言列表信息存储至session中
	
	response.sendRedirect(request.getContextPath()+"/getMessage.jsp?subFlag=1");//重定向至留言板页面
%>