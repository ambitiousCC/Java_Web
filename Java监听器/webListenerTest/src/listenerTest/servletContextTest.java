package listenerTest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class servletContextTest implements ServletContextListener {

	//测试内容：获取初始化配置参数
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String version = (String) sce.getServletContext().getAttribute("version");
		System.out.println("destory--version="+version);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String version = sce.getServletContext().getInitParameter("version");
		sce.getServletContext().setAttribute("version",version);
		
		System.out.println("init--version="+version);
	}

}
