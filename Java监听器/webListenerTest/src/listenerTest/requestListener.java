package listenerTest;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class requestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("destoryed");		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		
		String path = request.getRequestURI();
		String par = request.getParameter("par");
		
		System.out.println("path:"+path+"\n"+"par:"+par);
		
	}
	
}
