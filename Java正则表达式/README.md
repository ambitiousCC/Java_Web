*	正则表达式基本语法
>	*	在html标签中input的pattern属性中设置，是前台校验
>	*	[a-zA-Z]		表示一个字母字符
>	*	\d				表示一个数字
>	*	X{n}				表示X格式的有n位
>	*	X{n,}			表示X格式的至少n位
>	*	X{n,m}			表示X格式的长度为n~m
>	*	\D				表示不是数字	
>	*	\s				表示空白字符(包括了空格、制表符\t、\n换行)
>	*	\S				表示非空白字符
>	*	\w				表示单词字符[a-zA-Z_0-9]
>	*	\W				非单词字符
>	*	+					表示至少出现一次
>	*	^					开始
>	*	$					结束
>	*	开始和结束都可以省略不写
>	*	在Java中有特定的字符串方法matches(String regex)//regex是指定的正则表达式规则
>	*	前台校验还可以利用inspect-editAsHtml-直接删除属性
```
	//例如：邮箱验证：单词字符出现至少三次，必须有@字符，
	//后面跟上字母字符，|代表或的意思，就是或者是数字并至少出现一次
	//最后有个点，点后面有字母字符，字母字符至少一次，并且包含点和字母字符在内的至少出现一次
	String emailRegex = "[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+";
	String email = request.getParameter("email");
	boolean flag = email.matches(emailRegex);
	if(flag) System.out.println("格式正确");
	else System.out.println("格式错误");
```
>	*	实际开发中要用到前台+后台两种校验方式
