package jdbc.test1;
import cc.jdbc.utils.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

@SuppressWarnings("unused")
public class test2 {
	@Test
	/**
	 * 查
	 */
	public void demo4() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8","root","cuiqin233");
			conn = JDBCUtils.loadConnect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			//一条记录
			//if(rs.next()) {System.out.println("");}
			//多条记录
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				
				System.out.println("uid="+uid+"     username="+username+"     password="+password+"      name="+name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, stmt,rs);
		}
	}
//	/**
//	 * 删
//	 */
//	public void demo3() {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8","root","cuiqin233");
//			stmt = conn.createStatement();
//			String sql = "DELETE FROM user WHERE uid = 2";
//			int i = stmt.executeUpdate(sql);
//			if(i>0) {
//				System.out.println("删除成功");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			finallydoclose.run(conn, stmt);
//		}
//	}
//	/**
//	 * 修改
//	 */
//	public void demo2() {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8","root","cuiqin233");
//			String sql = "UPDATE user SET username='ava',password='666',name='弟弟' WHERE uid = 1";
//			stmt = conn.createStatement();
//			int i = stmt.executeUpdate(sql);
//			if(i>0) {
//				System.out.println("执行成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			finallydoclose.run(conn,stmt);
//		}
//	}
	
	/**
	 * 插入语句
	 */
//	public void demo1() {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useEncoding=true&characterEncoding=utf8","root","cuiqin233");
//			String sql = "INSERT INTO user VALUES(null,'ddd','444','催情');";
//			stmt = conn.createStatement();
//			int i = stmt.executeUpdate(sql);
//			if(i>0) {
//				System.out.println("执行成功");
//			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			finallydoclose.run(conn, stmt);
//		}
//	}
	
}
