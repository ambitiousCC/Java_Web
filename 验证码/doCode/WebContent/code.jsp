<%@ page import="code.captcahCode" %><%--
  Created by IntelliJ IDEA.
  User: 崔秦
  Date: 2019/7/16
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //清空缓存流，去掉保存的图片
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-control","no-cache");
    response.setHeader("expires","0");

    //调用生成验证码的工具
    String code = captcahCode.drawImageVerificate(response);
    session.setAttribute("code", code);

    //解决getOutputSream
    out.clear();
    out = pageContext.pushBody();
%>
