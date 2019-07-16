package listenerTest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class listenerTest2 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("listener2 was destoryed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("listener2 was created");
	}

}
