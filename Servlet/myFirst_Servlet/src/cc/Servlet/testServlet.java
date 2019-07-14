package cc.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {

	
	@Override//每次访问都会调用
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("servlet被请求");
	}

	@Override//第一次访问才会调用
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet被第一次请求");
	}

	@Override//被调出服务器后
	public void destroy() {
		System.out.println("被销毁了");
	}

}
