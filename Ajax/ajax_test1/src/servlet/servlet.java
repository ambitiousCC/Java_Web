package servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("name");
		JSONObject json ;
		if(true) {
			json = new JSONObject("{flag:\"pop\"}");
		} else if("two".equals(str)) {
			json = new JSONObject("{flag:\"classes\"}") ;
		} else if("three".equals(str)) {
			json = new JSONObject("{flag:\"rock\"}");
		} else {
			json = new JSONObject("{flag:\"null\"}");
		}
		response.getOutputStream().write(json.toString().getBytes("utf-8"));
		//ajax给后台传输数据，后台必须有数据返回
		
//		String flag = request.getParameter("flag");
//		System.out.println(flag);
//		String data="";
//		if("1".equals(flag)) {
//			data = "小明<br>小红<br>小白";
//		} else if ("2".equals(flag)) {
//			data = "职员<br>经理";
//		} else if ("3".equals(flag)) {
//			data = "<h1>一块红布</h1><br><h1>假行僧</h1><br><h1>新长征路上的摇滚</h1>";
//		}
//		response.getOutputStream().write(data.getBytes("UTF-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
