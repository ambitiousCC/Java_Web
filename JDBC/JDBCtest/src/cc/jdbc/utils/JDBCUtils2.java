package cc.jdbc.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cc.jdbc.utils.JDBCUtils2;

public class JDBCUtils2 {
	private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	static {
		Properties props = new Properties();
		InputStream in = JDBCUtils2.class.getClassLoader().getResourceAsStream("c3p0.config.properties");
		try {
			props.load(in);
			datasource.setDriverClass(props.getProperty("driverClass"));
			datasource.setJdbcUrl(props.getProperty("jdbcUrl"));
			datasource.setUser(props.getProperty("user"));
			datasource.setPassword(props.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
		}
	}
	/**
	 * 获得链接
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 */
	public static Connection getConnect() throws ClassNotFoundException, SQLException, Exception {
		Connection conn= datasource.getConnection();
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
