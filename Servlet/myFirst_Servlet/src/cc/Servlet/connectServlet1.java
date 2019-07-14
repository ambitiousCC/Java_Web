package cc.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connectServlet1
 */
@WebServlet("/connectServlet1")
public class connectServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//从工程中获取到设置的属性值
//		ServletContext context = this.getServletContext();
//		Object con = context.getAttribute("a");
//		System.out.println(con);
		//获取Servlet配置值
		ServletConfig sc = this.getServletConfig();
		//获取参数信息
		String encoding = sc.getInitParameter("encoding");
		System.out.println("encoding="+encoding);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
