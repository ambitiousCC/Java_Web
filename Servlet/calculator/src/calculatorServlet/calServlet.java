package calculatorServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class calServlet extends HttpServlet {
    //����PrintWrite��ӡ
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("n1");
		String num2 = request.getParameter("n2");
		
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int sum = n1 + n2;
		
		//��һ�֣�ֱ����ҳ���ӡ
//		request.setAttribute("sum",sum);//��������Ӧ
//		PrintWriter out = response.getWriter();
//		out.append("<html>");
//		out.append("<body>");
//		out.append("<p>�ӷ���������</p>");
//		out.append("<p>������Ϊ��</p>"+sum);
//		out.append("</body>");
//		out.append("</html>");
//		//request.getRequestDispatcher("/calculatro.jsp").forward(request, response);
		
		//�ڶ��֣�ת��
//		request.setAttribute("sum", sum);
//		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
		//�����֣��ض���
		ServletContext sc = request.getServletContext();
		sc.setAttribute("sum", sum);
		response.sendRedirect("/calculator/result.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}