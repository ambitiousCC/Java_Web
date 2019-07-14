package cc.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

	//继承了HttpServlet以后就成为了一个Servlet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		System.out.println("前段传入数据");
		System.out.println("用户名" + account);
		System.out.println("密码" + password);
		//System.out.println("执行了GET方法");
		//在此处测试获得xml配置信息
		ServletConfig sc = this.getServletConfig();
		String encoding = sc.getInitParameter("encoding");
		System.out.println("配置封装好的encoding="+encoding);
		
		//转发与重定向的区别
		//转发只跳转一次，重定向跳转两次
		if("admin".equals(account) && "123".equals(password))//中间的路径从工程开始
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		else {
			//request.getRequestDispatcher("/fail.jsp").forward(request, response);
			//重定向需要重写工程名
			response.sendRedirect("/myFirst_Servlet/fail.jsp");
		}
	}//直接通过地址栏访问，执行的是GET

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//通常可以不论是哪种方法都可以统一
		doGet(req,resp);
		//System.out.println("执行了POST方法");
	}
}