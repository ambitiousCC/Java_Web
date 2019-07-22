*	心得
自己解决问题的能力越来越高了，遇到bug一点也不紧张，因为知道哪里可能出现，然后再方法中多使用sout
来发现那一段语句无法执行，发现系统配置文件必须放在src文件下面
但是强迫症，想要引入kapcha验证码框架，成功了但是没有作用。。浪费了我四五个小时
数据库操作时，execute才会用于执行操作，executeQuery只能用于更新操作

```
常用数据库约束ENGINE=INNODB CHARSET=UTF8;
sex ENUM('男','女','保密')

```
```
//每次初始化页面没有输入验证码都要把onclick禁用
			$("#login-btn").attr("onclick",false);

			$("#changeCode").click(function(){
				$("#img").attr("src","kaptcha.jpg?d="+new Date().getTime());
			});

			//传递点击事件
			$("#login-btn").click(function(){
				//获取输入的验证码
				var code = $("#verificationCode").val();
				//以上客户端完成
				var params = {"code":code};
				//ajax向地址传递code，返回data
				$.post("login",params,function(data){
					var verificationCode = $("#verificationCode").value;
					var allCookies = document.cookie;
					var cookie_pos = allCookies.indexOf('v_c_v');   //如果找到了索引，就代表cookie存在
					var Cookies = null;
					if (cookie_pos != -1) {
						cookie_pos += cookie_name.length + 1;
						var cookie_end = allCookies.indexOf(";", cookie_pos);
						if (cookie_end == -1) {
							cookie_end = allCookies.length;
						}
						Cookies = unescape(allCookies.substring(cookie_pos, cookie_end));
					}
					var flag = (Cookies == verificationCode);
					if(!flag) {
						alert("验证码输入错误")
						//完善了一个输入错误就重新刷新的功能
						$("#img").attr("src","kaptcha.jpg?d="+new Date().getTime());
						$("#verificationCode").val("").focus();
					} else {
						//否则登录成功，并且把属性值变成true
						$("#login-btn").attr("onclick", true);
					}
				});
			});
```