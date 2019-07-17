<%--
  Created by IntelliJ IDEA.
  User: 崔秦
  Date: 2019/7/17
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>java验证码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  </head>
  <body>

     <img src="code.jsp" alt="" id="code">
     <a href="javascript:void(0);" onclick="changeCode()">看不清？点我</a>
     <script>

         function changeCode() {
             document.getElementById("code").src = "code.jsp?d="+new Date().getTime();
         }

     </script>
  </body>
</html>
