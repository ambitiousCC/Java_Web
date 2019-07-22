package usejdbc.dao;

import usejdbc.bean.Message;
import usejdbc.common.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息DAO
 */
public class MessageDAO {
    public static boolean addMessage(Message message) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //查询
            String sql = "INSERT INTO message(user_id,username,title,content,create_time) VALUES (?,?,?,?,?)";
            conn = ConnectionUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1,message.getUserId());
            pstmt.setString(2, message.getUsername());
            pstmt.setString(3, message.getTitle());
            pstmt.setString(4,message.getContent());
            //datetime
            pstmt.setTimestamp(5, new Timestamp(message.getCreateTime().getTime()));
            pstmt.execute();
        } catch (Exception e) {
            System.out.println("插入数据不成功");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtils.release(conn, pstmt);
        }
        return true;
    }


    /**
     * 查询数据库中的message信息
     * @param page
     * @param pageSize
     * @return
     */
    public static List<Message> getMessage(int page,int pageSize) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //查询
        String sql = "SELECT * FROM message order by create_time desc limit ?,?";
        List<Message> messages = new ArrayList<>();
        try {
            conn = ConnectionUtils.getConnection();
            pstmt = conn.prepareStatement(sql);//先预编译再设置
            System.out.println("testforconnection2");
            pstmt.setInt(1,(page-1)*pageSize);
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTime("create_time")));
            }
            return messages;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtils.release(conn, pstmt, rs);
        }
        return messages;
    }

    /**
     * c查询数据库中一共有几条信息
     * @return
     */
    public static int getMessageCount() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //查询
            String sql = "SELECT COUNT(*) total FROM message";
            conn = ConnectionUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtils.release(conn, pstmt, rs);
        }
        return 0;
    }
}
