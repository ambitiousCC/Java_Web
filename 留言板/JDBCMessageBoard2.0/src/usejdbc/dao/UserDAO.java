package usejdbc.dao;

import jdk.nashorn.internal.runtime.ECMAException;
import usejdbc.bean.User;
import usejdbc.common.ConnectionUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户明密码
 */
public class UserDAO {
    /**
     * 从数据库中得到用户信息
     * @param username
     * @param password
     * @return
     */
    public static User login(String username, String password) {
        User user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("real_name"),
                        rs.getTimestamp("birthday"),
                        rs.getString("phone"),
                        rs.getString("address")
                        );
            }
            return user;
        } catch (Exception e) {
            System.out.println("用户名或密码错误，登录失败");
            e.printStackTrace();
        } finally {
            ConnectionUtils.release(conn, pstmt, rs);
        }
        return user;
    }

    /**
     * 通过id来获取用户的信息
     * @param id
     * @return
     */
    public static User getUserById(Long id) {
        User user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM user WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("real_name"),
                        rs.getTimestamp("birthday"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
            }
            return user;
        } catch (Exception e) {
            System.out.println("获取失败");
            e.printStackTrace();
        } finally {
            ConnectionUtils.release(conn, pstmt, rs);
        }
        return user;
    }

    /**
     * 只更新不查询
     * @param user
     * @return
     */
    public static boolean updataUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //id不能修改
            conn = ConnectionUtils.getConnection();
            String sql = "UPDATE user SET username=?,password=?,real_name=?,birthday=?,phone=?,address=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRealName());
            //注意Date的格式
            pstmt.setDate(4, new Date(user.getBirthday().getTime()));
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getAddress());
            pstmt.setLong(7, user.getId());
            pstmt.execute();
        } catch (Exception e) {
            System.out.println("获取失败");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtils.release(conn, pstmt, rs);
        }
        return true;
    }
}
