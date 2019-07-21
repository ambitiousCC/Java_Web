package jdbc.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
import cc.jdbc.utils.JDBCUtils2;

public class test4 {
	@Test
	/**
	 * 数据库连接池
	 */
	public void demo2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnect();
			String sql = "SELECT * FROM user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("uid")+"    "+rs.getString("username")+"    "+rs.getString("password")+"     "+rs.getString("name"));
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.run(conn, pstmt,rs);
		}
	}
//	public void demo1(){
//
//	// 获得连接:
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	try{
//		// 创建连接池:
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		// 设置连接池的参数:
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		dataSource.setJdbcUrl("jdbc:mysql:///jdbctest?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC");
//		dataSource.setUser("root");
//		dataSource.setPassword("cuiqin233");
//		dataSource.setMaxPoolSize(20);
//		dataSource.setInitialPoolSize(3);
//		
//		// 获得连接:
//		conn = dataSource.getConnection();
//		// 编写Sql:
//		String sql = "select * from user";
//		// 预编译SQL:
//		pstmt = conn.prepareStatement(sql);
//		// 设置参数
//		// 执行SQL:
//		rs = pstmt.executeQuery();
//		while(rs.next()){
//			System.out.println(rs.getInt("uid")+"   "+rs.getString("username")+"   "+rs.getString("password")+"   "+rs.getString("name"));
//		}
//	}catch(Exception e){
//		e.printStackTrace();
//	}finally{
//		JDBCUtils.run(conn,pstmt,rs);
//	}
//}
}
