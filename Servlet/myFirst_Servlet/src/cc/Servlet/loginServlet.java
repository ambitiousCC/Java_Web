package cc.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

	//�̳���HttpServlet�Ժ�ͳ�Ϊ��һ��Servlet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		System.out.println("ǰ�δ�������");
		System.out.println("�û���" + account);
		System.out.println("����" + password);
		//System.out.println("ִ����GET����");
		//�ڴ˴����Ի��xml������Ϣ
		ServletConfig sc = this.getServletConfig();
		String encoding = sc.getInitParameter("encoding");
		System.out.println("���÷�װ�õ�encoding="+encoding);
		
		//ת�����ض��������
		//ת��ֻ��תһ�Σ��ض�����ת����
		if("admin".equals(account) && "123".equals(password))//�м��·���ӹ��̿�ʼ
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		else {
			//request.getRequestDispatcher("/fail.jsp").forward(request, response);
			//�ض�����Ҫ��д������
			response.sendRedirect("/myFirst_Servlet/fail.jsp");
		}
	}//ֱ��ͨ����ַ�����ʣ�ִ�е���GET

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ͨ�����Բ��������ַ���������ͳһ
		doGet(req,resp);
		//System.out.println("ִ����POST����");
	}
}