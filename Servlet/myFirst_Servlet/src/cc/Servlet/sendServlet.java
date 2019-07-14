package cc.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendServlet
 */
@WebServlet("/sendServlet")
public class sendServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//转发可以利用request传递数据
//		request.setAttribute("a", "cc");//成功
//		request.getRequestDispatcher("/recieve.jsp").forward(request, response);
		
		//重定向不能response
		ServletContext sc = request.getServletContext();
		sc.setAttribute("b", "dd");
		response.sendRedirect("/myFirst_Servlet/recieve.jsp");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
