package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.code.kaptcha.Constants;

public class loginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取浏览器的输出流对象
		PrintWriter out = response.getWriter();
		//获取用户传递过来的验证码
		String code = request.getParameter("code");
		//获取验证码框产生的验证码
		String sessionCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String data = "";
		if(code!=null&&sessionCode!=null) {
			//输入的验证码和服务器生成的验证码一致那么就会成功
			if(code.equalsIgnoreCase(sessionCode)) {
				//下面可以继续一些业务逻辑
				//注意这里的out中的print和System中的out不一样！是向后台传递参数
				out.print("s");
			} else {
				out.print("f");
			}
		} else {
			out.print("f");
		}
		//关闭
		out.close();
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
