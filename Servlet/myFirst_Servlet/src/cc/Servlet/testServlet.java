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

	
	@Override//ÿ�η��ʶ������
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("servlet������");
	}

	@Override//��һ�η��ʲŻ����
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet����һ������");
	}

	@Override//��������������
	public void destroy() {
		System.out.println("��������");
	}

}
