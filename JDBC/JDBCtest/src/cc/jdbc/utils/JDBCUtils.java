package cc.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String drivername;
	private static String URL;
	private static String username;
	private static String password;
	
	static {
		//配置属性文件来得到数据防止修改源码
		//加载
		Properties prop = new Properties();
		//流:利用类的加载器
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("JDBCtest.properties");
		//属性中加载流
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		drivername = prop.getProperty("drivername");
		URL = prop.getProperty("URL");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	/**
	 * 注册驱动
	 * @throws ClassNotFoundException 
	 */
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName(drivername);
	}
	/**
	 * 获得链接
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection loadConnect() throws SQLException, ClassNotFoundException {
		loadDriver();
		Connection conn= DriverManager.getConnection(URL,username,password);
		return conn;
	}
	/**
	 * 资源释放
	 * @param conn
	 * @param stmt
	 */
	public static void run(Connection conn,Statement stmt) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}

		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	/**
	 * 资源释放
	 * @param conn
	 * @param stmt
	 * @param resultSet
	 */
	public static void run(Connection conn,Statement stmt,ResultSet resultSet) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}

		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultSet = null;
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
	}
}
