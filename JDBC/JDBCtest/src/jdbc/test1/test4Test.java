package jdbc.test1;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Ignore;
import org.junit.Test;

import cc.jdbc.utils.JDBCUtils2;

public class test4Test {

	@Ignore//表示测试
	public void testDemo2() {
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

}
