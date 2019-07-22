package usejdbc.filter;

import usejdbc.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //做法原因：从前面的req中获得user的值
        //如果没有就是空值:这里也对应了从修改以后的地方查到
        User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        servletRequest.setAttribute("user",user);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
