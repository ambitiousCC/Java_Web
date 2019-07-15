*	Java过滤器
>	*	对服务器资源权限的控制、字符集编码、内容铭感字符过滤、响应信息压缩
>	*	需要javax.servlet.Filter接口
>	*	主要功能是解决中文乱码、强制访问等
>	*	需要在web.xml中配置参数
>	*	和servlet差不多，有doFilter/destory/init等方法
>>	*	初始化时候会执行init方法，页面访问会执行doFilter方法，修改类等操作会销毁并重建
>	*	在xml文件中初始化参数配置<init-param>+<param-name>+<param-value>

*	配置方法：REQUEST(默认)、INCLUDE、FORWARD、ERROR 四种调用方式
>	*	xml中标签的含义：
>>	*	welcome-file：首页，直接访问工程的页面
>>	*	filter：过滤器注册，中间包含了名字和类以及配置参数，名字可以自取，类必须是java包，配置参数也是自设：可以有版本version、字符charset等等
>>	*	filter-mapping：过滤器映射：filter-name与相邻上方的filter-name保持一致、url-pattern是映射路径也是访问对象在指定的dispatcher下面触发的过滤器
>>	*	error-page：ERROR方式触发过滤器然后指定的自己的页面对错误进行处理，页面属性是标签location
>>	*	可以类比servlet标签
>>	*	总之就是：特定方式访问页面-->触发设置好的过滤器-->结束

>	*	可以在过滤器中设置对资源的访问从而再次触发过滤器
>	*	直接访问--REQUEST--也是默认的dispatcher方式
>	*	通过include来访问另外一个页面，访问页面方式就认为是通过include方式调用，同时调用了两个页面？也执行了过滤器，需要标签<jsp:include page="进一步访问的页面对象"></jsp:include>
>	*	request的dispatcher(url)对象的forward(request,response)方法访问时候就是通过forward过滤器
>	*	error通过异常声明时异常处理机制，过滤器就是通过error过滤器调用，可以设置error-page设置错误处理页面
>>	*	也就是需要需要<error-page>+<error-code>+<location>标签
>	*	还可以进行dispatcher的多个子元素配置，配置的方法执行都可以触发过滤器

*	总结
>	*	简单的留言板
>	*	通过配置和config方法解决了中文乱码问题
>	*	解决了强制访问页面的问题
>	*	仔细研究了xml对filter配置的问题--即过滤器触发的问题