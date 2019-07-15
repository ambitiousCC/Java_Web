package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter2 implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println(">>>>>>>>TestFilter2 execute doFilter... ...");
		//过滤器中资源调用
		//只要符合调用规则就可以
		request.getRequestDispatcher("/test2.jsp").forward(request, response);
		//chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
