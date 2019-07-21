package jdbc.test1;
import cc.jdbc.utils.*;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class test1 {
	@Test
	/**
	 * 创建
	 */
	public void demo1() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			//DriverManager.registerDriver(new Driver());
//			Class.forName("com.mysql.jdbc.Driver");
			//这个对象是连接对象
			//用来创建sql语句
			//prepareStatement  
			String sql = "select * from user";
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8","root","cuiqin233");
			conn = JDBCUtils.loadConnect();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
				int uid = resultSet.getInt("uid");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				
				System.out.println("uid="+uid+",username="+username+",password="+password+",name="+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.run(conn,stmt,resultSet);
		}
	}
	
	
	
	
	//@Test
	/**
	 * 	第一个
	 */
	/**
	public void demo1() {
		try {
			DriverManager.registerDriver(new Driver());
			//这个对象是连接对象
			//用来创建sql语句
			//prepareStatement  
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8","root","cuiqin233");
			String sql = "select * from user";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
				int uid = resultSet.getInt("uid");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				
				System.out.println("uid="+uid+",username="+username+",password="+password+",name="+name);
			}
			resultSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
