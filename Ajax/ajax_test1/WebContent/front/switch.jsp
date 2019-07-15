<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() +":"+ request.getServerPort()
					+ request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</style>
</head>
<body>
<input type="button" value="流行歌曲" class="btn" />
<input type="button" value="经典歌曲"  class="btn" />
<input type="button" value="摇滚歌曲"	class="btn" />
<br>
<div class="con">
<h1 class="content1"></h1>
<h1 class="content2"></h1>
<h1 class="content3"></h1>
</div>
</script>
</body>
</html>