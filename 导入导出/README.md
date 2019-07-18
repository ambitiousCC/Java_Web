*	尴尬
>	*	在上一节出现的问题，在这一节全被解决了。。woc


*	WEB-INF下的文件
>	*	利用servlet拦截后访问，需要配置
```
结合jsp和servlet来做就是先访问Servlet
```

*	common.jsp：所有目录下面的jsp文件都可以访问common.jsp
```
<jsp-config>
	<jsp-property-group>
		<url-pattern>*.jsp</url-pattern>
		<include-prelude>/WEB-INF/jsp/common.jsp<include-prelude>
	</jsp-property-group>
</jsp-config>
```
*	这一节只是分析了过程，但是解析器并不需要而且现在不知道能不能解析word2019等高版本的，所以暂时没有去实现
*	主要学到了进一步配置IDEA以及在程序中引入jsp共通文件，设置默认首页等等内容
