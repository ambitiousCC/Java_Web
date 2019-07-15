*	ajax局部刷新
>	*	基本语法
```
//事件A包括点击click等
$("#id").事件A(function(){
	//匿名函数封装
	//触发ajax事件
	$.ajax({
		//json形式：
		url:"",
		type:"",
		data:{
			//向后端传入的数据，后端用request.getParameter()方法获取
		},
		dataType:"json",//返回数据是json格式
		success:function(result) {
			//result中封装了Servlet返回给Ajax的结果
			var flag = result.flag;//result中存储的flag值
			//假如是if-else判断语句
			if(flag) {
				//一般是跳转到成功页面
				window.location.href=url;
			} else {
				//既然是局部刷新，在需要刷新的位置设置空标签给提示信息
				$(".class").text(String);//向类是class的标签中插入信息
			}
		}
	});
});
```
>	*	在java中响应
```
//需要引入json.jar，创建JSON对象
JSONObject json = new JSONObject("{:}");
//返回利用到了resonse中的流方法
response.getOutputStream(),write(json.toString().getBytes("utf-8"));//设置字符编码，write中传入String类型
```
>	*	ajax给后台传输数据，后台必须有数据返回

*	遇到的问题
>	*	使用jq一定要先引用jq！！！
>	*	jq配置问题：太卑微了找不到问题出在哪里，只能使用测试成功的当做框架
>	*	jq中this的问题，可以使用this获取触发事件的对象的属性
>	*	向servlet传送ajax数据中文乱码问题(仍然没有解决,最终通过英文的形式完成)
>	*	双引号内需要转义符号添加双引号
>	*	ajax中没有equal方法，只能使用==直接比较