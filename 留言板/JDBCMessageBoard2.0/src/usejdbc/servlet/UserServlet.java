package usejdbc.servlet;

import usejdbc.bean.User;
import usejdbc.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class UserServlet extends HttpServlet {
    private static UserService userService;
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (Objects.equals("/userInfo.do", path)) {
            req.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(req, resp);
        } else if (Objects.equals("/editUserPrompt.do", path)) {
            //获取用户信息的两种方式
            //1.从session中获得
            //2.从数据库中查询获得
            Long id = Long.valueOf(req.getParameter("id"));
            User user = UserService.getUserById(id);
            //严谨判断
            if (null != user) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/views/biz/edit_user.jsp").forward(req,resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/error/user.jsp").forward(req, resp);
            }
        } else if (Objects.equals("/editUser.do", path)) {
            //从form表单中获取信息是Parameter
            Long id = Long.valueOf(req.getParameter("id"));
            String username = req.getParameter("name");
            String password = req.getParameter("password");
            String realName = req.getParameter("realName");
            String birthdayStr = req.getParameter("birthday");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");

            //注意birthday需要转换类型
            Date birthday = null;
            System.out.println(birthdayStr);
            try {

                //注意从数据库中取出的date类型会带有时分秒，而datatime没有所以有两种不同的装换类型
                //date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String s = sdf.format(new Date());
                birthday = sdf.parse(s);
                //datetime
                //birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
            } catch (ParseException e) {
                System.out.println("日期格式化不成功");
                e.printStackTrace();
            }

            User user = new User(id, username, password, realName, birthday, phone, address);
            boolean flag = userService.updateUser(user);
            if (flag) {
                req.getSession().setAttribute("user", user);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/biz/404.jsp").forward(req, resp);
            }

        } else {
            req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
        }
    }

}
