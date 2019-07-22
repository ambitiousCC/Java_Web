package usejdbc.servlet;

import com.google.code.kaptcha.Constants;
import usejdbc.bean.User;
import usejdbc.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = new UserService();//只会被创建一次
    }

    /**
     * 每次都会执行
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (null != user) {
            System.out.println("登录测试");
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(req,resp);
        }
    }
}
