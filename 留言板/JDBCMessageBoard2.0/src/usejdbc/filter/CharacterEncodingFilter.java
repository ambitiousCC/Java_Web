package usejdbc.filter;

import java.io.IOException;

import javax.servlet.*;

public class CharacterEncodingFilter implements Filter {
	private FilterConfig config;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException{
		//过滤器应该怎么返回到原来的页面去？
		request.setCharacterEncoding(config.getInitParameter("charset"));
		response.setCharacterEncoding(config.getInitParameter("charset"));
		try {
			chain.doFilter(request, response);
		} catch (ServletException e) {
			System.out.println("服务器出错");
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		System.out.println("字码集被销毁");
	}

	@Override
	public void init(FilterConfig config){
		this.config = config;
	}


}
