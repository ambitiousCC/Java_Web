package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {
	private FilterConfig config;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		//通知拦截完成操作
//		String systemName = config.getInitParameter("systemName");
//		String version = config.getInitParameter("version");
//		
//		//获取初始化信息
//		System.out.println("systemName="+systemName);
//		System.out.println("version="+version);
		
		//request.setCharacterEncoding("UTF-8");//如果直接这样设置就会导致之后需要修改设置
		//设置防止中文乱码
		request.setCharacterEncoding(config.getInitParameter("charset"));
		
		//过滤器操作需要强转
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponse hresponse = (HttpServletResponse)response;
		
		String loginUser = (String)hrequest.getSession().getAttribute("loginUser");
		
		if(loginUser==null) {
			//明显没有登录就直接访问页面
			hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?flag=1");
			return ;
		} else {
			//否则就可以说明拦截完毕
			chain.doFilter(request, response);
			return ;
		}
		
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//可以在初始化的时候获得配置参数
		this.config = config;
	}
	
	//一般不会使用get和set方法
	public void setConfig (FilterConfig config) {
		this.config=config;
	}
	public FilterConfig getConfig() {
		return config;
	}

}
