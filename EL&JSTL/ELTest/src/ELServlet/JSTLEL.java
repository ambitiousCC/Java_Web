package ELServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JSTLEL extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建集合测试
		String ss = (String)request.getParameter("df");
		System.out.println(ss);
		int[] arr = new int[101];
		for(int i=100;i<=200;i++) {
			arr[i-100] = i;
		}
		for(int ar : arr) {
			System.out.println(ar);
		}
		request.setAttribute("arr", arr);
		request.getRequestDispatcher("/switch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
