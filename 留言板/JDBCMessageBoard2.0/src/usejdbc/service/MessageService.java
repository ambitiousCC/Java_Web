package usejdbc.service;

import usejdbc.bean.Message;
import usejdbc.dao.MessageDAO;

import java.util.Date;
import java.util.List;

/**
 * 消息的服务
 */
public class MessageService {
    private MessageDAO messageDAO;
    public MessageService() {
        messageDAO = new MessageDAO();
    }

    /**
     * 从数据库中查询信息
     * @param page
     * @param pageSize
     * @return
     */
    public static List<Message> getMessages(int page,int pageSize) {
        System.out.println("test.message");
        return MessageDAO.getMessage(page, pageSize);
    }
    /**
     * c查询数据库中一共有几条信息
     * @return
     */
    public static int getMessageCount() {
        System.out.println("test.count");
        return MessageDAO.getMessageCount();
    }

    public static boolean addMessage(Message message) {
        message.setCreateTime(new Date());
        return MessageDAO.addMessage(message);
    }

}
