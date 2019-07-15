*	EL表达式
>	*	${attribute}
>	*	可以大大简化取出数据的代码

*	JSTL
>	*	需要前缀声明：<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>	*	通用标签
>>	*	set/out/remove
>>	*	if/choose
>>	*	forEach

*	下面是各种标签语法
*	set：将value值存储到范围为scope中的变量var中
>	*	<c:set var="xxx" value="xxx" scope="xxx" />
*	out：将结果输出显示
>	*	<c:out value="xxx" /> **xxx是字符时直接用字符代替，是request中的属性时需要${}语法**
*	remove：删除指定域内数据
>	*	<c:remove var="xxx" scope="xxx" />
*	if：拥有的test:接判断的条件
>	*	<c:if tet="xxx" />
*	choose：不能单独使用，需要使用when和otherwise
```
<c:choose>
	<c:when test="${age==12}">
		true
	</c:when>
	<c:otherwise>
		false
	</c:otherwise>
</c:choose>
```
*	forEach:一般用来遍历
>	*	先看看foreach方法for(数据类型 迭代器 : 对象) {使用迭代器就可以迭代}
>	*	语法<c:forEach item="被遍历对象" var="迭代器" begin="" end="" step=""/>
*	运算符
```
算术运算符 + 、 - 、 * 、 / （或 div ）和 % （或 mod ） 
关系运算符 == （或 eq ）、 != （或 ne ）、 < （或 lt ）、 > （或 gt ）、 <= （或 le ）和 >= （或 ge ） 
逻辑运算符 && （或 and ）、 || （或 or ）和 ! （或 not ） 
验证运算符 empt
```
>	*	注意：E要大写
>	*	404错误：找不到文件！检查路径是否写对！最后检查配置的xml文件的路径！
>	*	EL直接就可以使用，而JSTL需要导包的同时还要在前面声明


