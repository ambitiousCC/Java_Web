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
//		//֪ͨ������ɲ���
//		String systemName = config.getInitParameter("systemName");
//		String version = config.getInitParameter("version");
//		
//		//��ȡ��ʼ����Ϣ
//		System.out.println("systemName="+systemName);
//		System.out.println("version="+version);
		
		//request.setCharacterEncoding("UTF-8");//���ֱ���������þͻᵼ��֮����Ҫ�޸�����
		//���÷�ֹ��������
		request.setCharacterEncoding(config.getInitParameter("charset"));
		
		//������������Ҫǿת
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponse hresponse = (HttpServletResponse)response;
		
		String loginUser = (String)hrequest.getSession().getAttribute("loginUser");
		
		if(loginUser==null) {
			//����û�е�¼��ֱ�ӷ���ҳ��
			hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?flag=1");
			return ;
		} else {
			//����Ϳ���˵���������
			chain.doFilter(request, response);
			return ;
		}
		
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//�����ڳ�ʼ����ʱ�������ò���
		this.config = config;
	}
	
	//һ�㲻��ʹ��get��set����
	public void setConfig (FilterConfig config) {
		this.config=config;
	}
	public FilterConfig getConfig() {
		return config;
	}

}
