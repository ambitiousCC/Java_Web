package jdbc.test1;
import cc.jdbc.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
/**
 * 更好使用的PreparedStatement
 * @author 崔秦
 *
 */
public class test3 {
	@Test
	/**
	 * test的
	 */
	public void testforall() {
//		//查--修改之前
//		this.ser();
//		//增
//		this.add(7, "a", "12345", "滴滴");
//		//删
//		this.del(4);
		//改
		this.update(3, "b", "123", "涛哥");
		//查
		this.ser(1);
	}
	/**
	 * 查所有
	 */
	public void ser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.loadConnect();
			String sql = "SELECT * FROM  user;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("uid="+rs.getString("uid")+"   username="+rs.getString("username")+"   password="+rs.getString("password")+"   name="+rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, pstmt,rs);
		}
	}
	/**
	 * 查
	 */
	public void ser(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.loadConnect();
			String sql = "SELECT * FROM user WHERE uid=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("uid="+rs.getString("uid")+"   username="+rs.getString("username")+"   password="+rs.getString("password")+"   name="+rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, pstmt,rs);
		}
	}
	/**
	 * 改
	 */
	public void update(int uid,String username,String password,String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.loadConnect();
			String sql = "UPDATE user SET username=?,password=?,name=? WHERE uid=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(4,uid);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setString(3,name);
			int i = pstmt.executeUpdate();
			if(i>0) {
				System.out.println("改成功");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, pstmt);
		}
	}
	/**
	 * 删
	 */
	public void del(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.loadConnect();
			String sql = "DELETE FROM user WHERE uid=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,uid);
			int i = pstmt.executeUpdate();
			if(i>0) {
				System.out.println("删成功");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, pstmt);
		}
	}
	/**
	 * 增
	 */
	public void add(int uid,String username,String password,String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.loadConnect();
			String sql = "INSERT INTO user VALUES(?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,uid);
			pstmt.setString(2,username);
			pstmt.setString(3,password);
			pstmt.setString(4,name);
			int i = pstmt.executeUpdate();
			if(i>0) {
				System.out.println("加成功");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, pstmt);
		}
	}
//	/**
//	 * 解决SQL注入漏洞的代码
//	 */
//	public void demo1 (){
//		boolean flag = this.login2("ava","666");
//		if(flag==true) {
//			System.out.println("登录成功");
//		} else {
//			System.out.println("登录失败");
//		}
//	}
	
	public boolean login2(String username,String password) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.loadConnect();
			//这时候方法不一样了
			String sql = "SELECT * FROM user WHERE username=? and password=?";
			//预编译
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn, pstmt,rs);
		}
		return flag;
	}
	
//	/**
//	 * SQL漏洞注入
//	 * @param username
//	 * @param password
//	 * @return
//	 */
//	public boolean login(String username,String password) {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		boolean flag = false;
//		try {
//			conn = JDBCUtils.loadConnect();
//			stmt = conn.createStatement();
//			String sql = "SELECT * FROM user WHERE username='"+username+"' and password='"+password+"'";
//			rs = stmt.executeQuery(sql);
//			if(rs.next()) {
//				flag = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtils.run(conn, stmt,rs);
//		}
//		return flag;
//	}
}
