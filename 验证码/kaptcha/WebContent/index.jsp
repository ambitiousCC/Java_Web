<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="submit.action">
    <p>验证码:</p>
    <input type="text" name="kaptcha" value="" id="code" maxlength="4" placeholder="请输入验证码"/>
    <img src="kaptcha.jpg"  id="changecode" class="changecode"/>
    <p><input type="button" value="登录" id="login" /></p>
    <div id="result"></div>
</form>
<script src="js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$("#changecode").click(function(){
		$(this).attr("src","kaptcha.jpg?d="+new Date().getTime());			
	});
	
	//传递点击事件
	$("#login").click(function(){
		//获取输入的验证码
		var code = $("#code").val();
		//以上客户端完成
		var params = {"code":code};
		//ajax向地址传递code，返回data
		$.post("login",params,function(data){
			if(data=="s") {
				$("#result").html("验证码输入正确");
			} else {
				$("#result").html("验证码输入错误");
				//完善了一个输入错误就重新刷新的功能
				$("#changecode").attr("src","kaptcha.jpg?d="+new Date().getTime());
				$("#code").val("").focus();
			}
		});
	});
</script>
</body>
</html>