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
		//�ӹ����л�ȡ�����õ�����ֵ
//		ServletContext context = this.getServletContext();
//		Object con = context.getAttribute("a");
//		System.out.println(con);
		//��ȡServlet����ֵ
		ServletConfig sc = this.getServletConfig();
		//��ȡ������Ϣ
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