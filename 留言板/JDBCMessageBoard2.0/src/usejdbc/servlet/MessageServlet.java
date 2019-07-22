package usejdbc.servlet;

import usejdbc.bean.Message;
import usejdbc.bean.User;
import usejdbc.service.MessageService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class MessageServlet extends HttpServlet {

    private MessageService messageService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        messageService = new MessageService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (Objects.equals("/addMessagePrompt.do", path)) {
            req.getRequestDispatcher("/WEB-INF/views/biz/add_message.jsp").forward(req,resp);
        } else if (Objects.equals("/addMessage.do", path)) {
            //保存页面
            User user = (User) req.getSession().getAttribute("user");;
            if (null != user) {
                //user的id可以共用
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                Message message = new Message(user.getId(), user.getUsername(), title, content);
                boolean result = messageService.addMessage(message);
                if (result) {
                    req.getRequestDispatcher("/message/list.do").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("/message/list.do").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
        }
    }
}
