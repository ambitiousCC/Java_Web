*	监听器
>	*	需要配置，可以只需要配置监听器类就可以并且多监听器是按照配置顺序执行，销毁时是按照配置的逆序执行。
>	*	三个对象：ServletContext+HttpSession+ServletRequest

*	ServletContext
>	*	contextInitialized(ServletContextEvent sce)
>	*	contextDestroyed(ServletContextEvent sce)
>	*	监听服务器的创建和销毁

*	HttpSession
>	*	sessionCreate(HttpSessionEvent hse)
>	*	sessionDestroyed(httpSessionEvent hse)
>	*	配置时配置有效期<session-config>+<session-timeout>单位是分钟，必须是整数
>	*	监听会话的创建和销毁

*	ServletRequest
>	*	requestInitialized(ServletRequestEvent sre)
>	*	requestDestroyed(ServletRequestEvent sre)
>	*	监听请求：只要对服务器进行请求就可以监听获得请求中的数据

*	域对象监听事件监听属性
>	*	attributeRemove attributeAdded attributeReplaced
>	*	其中attributeReplaced是重新set一下属性触发

>	*	绑定到session中的某个对象的状态事件监听器
>	*	HttpSessionBindingListener
>	*	valueBound(HttpSessionBindingEvent event)监听对象绑定至HTTP会话(比如设置属性，常用登录绑定session)
>	*	valueUnbound(HttpSessionBindingEvent event)监听器对象从HTTP会话内修改、移除或者会话销毁时调用(比如remove属性，常用退出登录)

>	*	案例保证唯一登录
*	遇到的问题
>	*	注册过滤器的时候映射的地址就是过滤器生效的地址，然后确定未登录时触发重定向的路径是否正确
>	*	自行添加了防止乱码的功能，doFilter方法结束以后一定要chain.doFilter(request,response)告诉过滤器结束，配置的时候filter和filter-mapping放在相邻且filter-name保持一致