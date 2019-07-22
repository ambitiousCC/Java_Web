package usejdbc.servlet;

import usejdbc.bean.Message;
import usejdbc.service.MessageService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 消息列表
 */
public class MessageListServlet extends HttpServlet {
    private static MessageService messageService;
    @Override
    public void destroy() {
        super.destroy();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("test_init");
        super.init(config);
         messageService = new MessageService();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test_head");
        //功能1：分页显示:messageService中方法返回信息，是通过messageDAO中查询数据库的方法
        int page = 1;
        String pageStr = req.getParameter("page");
        if (null != pageStr && !"".equals(page)) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Message> messageList = messageService.getMessages(page,4);
        System.out.println("test_getmessages");
        int total = messageService.getMessageCount();
        System.out.println("test_getcounts");

        int last = total%4==0?total/4:(total/4)+1;
//        int next = page<last?page+1:last;
//        int pre = page<=1?page:page-1;
        req.setAttribute("messages",messageList);
        req.setAttribute("page", page);
        req.setAttribute("last",last);
//        req.setAttribute("nextPage", next);
//        req.setAttribute("prePage",pre);
        System.out.println("test");
        req.getRequestDispatcher("/WEB-INF/views/biz/message_list.jsp").forward(req,resp);
    }
}
